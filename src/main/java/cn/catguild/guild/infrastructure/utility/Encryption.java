package cn.catguild.guild.infrastructure.utility;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 默认的加密工具
 *
 * @author icyfenix@gmail.com
 * @date 2020/3/10 18:02
 **/
@Component
@AllArgsConstructor
public class Encryption {

	private final ApplicationContext applicationContext;

	/**
	 * 配置认证使用的密码加密算法：BCrypt
	 * 由于在Spring Security很多验证器中都要用到{@link PasswordEncoder}的加密，所以这里要添加@Bean注解发布出去
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	/**
	 * 使用默认加密算法进行编码
	 */
	public String encode(CharSequence rawPassword) {
		PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);
		return passwordEncoder.encode(Optional.ofNullable(rawPassword).orElse(""));
	}

}
