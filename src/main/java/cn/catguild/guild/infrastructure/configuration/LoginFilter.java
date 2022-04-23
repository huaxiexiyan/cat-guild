package cn.catguild.guild.infrastructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 修改登录过滤器中获取用户名密码的方式
 *
 * @author xiyan
 * @date 2022-03-10 23:56
 */

public class LoginFilter extends UsernamePasswordAuthenticationFilter {


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
				"Authentication method not supported: " + request.getMethod());
		}
		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			Map<String, String> loginData = new HashMap<>();
			try {
				loginData = new ObjectMapper().readValue(request.getInputStream(), Map.class);
			} catch (IOException ignored) {
			}
			String username = loginData.get(getUsernameParameter());
			String password = loginData.get(getPasswordParameter());
			if (username == null) {
				username = "";
			}
			if (password == null) {
				password = "";
			}
			username = username.trim();
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
			setDetails(request, authRequest);
			return this.getAuthenticationManager().authenticate(authRequest);
		} else {
			return super.attemptAuthentication(request, response);
		}
	}

}
