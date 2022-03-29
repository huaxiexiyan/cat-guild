package cn.catguild.guild.infrastructure.configuration;

import cn.catguild.guild.infrastructure.jaxrs.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring Security安全配置
 * <p>
 * 移除静态资源目录的安全控制，避免Spring Security默认禁止HTTP缓存的行为
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/8 0:09
 **/
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin((formLogin) ->
				formLogin
					.loginProcessingUrl("/api/login/account").permitAll()
			).authorizeRequests(authorizeRequests ->
				authorizeRequests
					.anyRequest().permitAll()//配置其余所有请求都需要授权
			)
			.cors()//配置允许跨域
			.and()
			.csrf().disable();//禁用 csrf 防御
		http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	/**
	 * http.addFilterAt 之后，该过滤器就会去处理 loginFilter.setFilterProcessesUrl 设置的url
	 *
	 * @return
	 * @throws Exception
	 */
	@Bean
	LoginFilter loginFilter() throws Exception {
		LoginFilter loginFilter = new LoginFilter();
		//登录成功
		loginFilter.setAuthenticationSuccessHandler((req, resp, authentication) -> {
			Object principal = authentication.getPrincipal();
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter out = resp.getWriter();
			Map<String,Object> map = new HashMap<>();
			map.put("status","ok");
			map.put("data",principal);
			ApiResponse<Object> principalR = ApiResponse.ok(principal);
			out.write(new ObjectMapper().writeValueAsString(map));
			out.flush();
			out.close();
		});
		//登录失败
		loginFilter.setAuthenticationFailureHandler((req, resp, e) -> {
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter out = resp.getWriter();
			ApiResponse<Object> fail = ApiResponse.fail(e.getMessage());
			out.write(new ObjectMapper().writeValueAsString(fail));
			out.flush();
			out.close();
		});
		loginFilter.setAuthenticationManager(authenticationManagerBean());
		loginFilter.setFilterProcessesUrl("/api/login/account");
		return loginFilter;
	}

	///**
	// * 核心安全策略
	// *
	// * @param http
	// * @return
	// * @throws Exception
	// */
	//@Bean
	//@Order(1)
	//SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	//	http.formLogin((formLogin) ->
	//			formLogin
	//				.loginProcessingUrl("/api/login/account").permitAll()
	//				.successHandler((req, resp, authentication) -> {//登录成功
	//					Object principal = authentication.getPrincipal();
	//					resp.setContentType("application/json;charset=utf-8");
	//					PrintWriter out = resp.getWriter();
	//					out.write(new ObjectMapper().writeValueAsString(principal));
	//					out.flush();
	//					out.close();
	//				}).failureHandler((req, resp, e) -> {//登录失败
	//					resp.setContentType("application/json;charset=utf-8");
	//					PrintWriter out = resp.getWriter();
	//					out.write(e.getMessage());
	//					out.flush();
	//					out.close();
	//				}).addObjectPostProcessor()
	//		).authorizeRequests(authorizeRequests ->
	//			authorizeRequests
	//				.anyRequest().authenticated()//配置其余所有请求都需要授权
	//		)
	//		.cors()//配置允许跨域
	//		.and()
	//		.csrf().disable();//禁用 csrf 防御
	//	http.apply(customDsl());
	//	return http.build();
	//}
}
