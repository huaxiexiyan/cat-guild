package cn.catguild.guild.domain.auth.service;

import cn.catguild.guild.domain.auth.AuthenticAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 认证用户信息查询服务（最终被spring security框架调用，来加载用户信息）
 * <p>
 * {@link UserDetailsService}接口定义了从外部（数据库、LDAP，任何地方）根据用户名查询到
 * @author xiyan
 */
@AllArgsConstructor
@Component
public class AuthenticAccountDetailsServiceImpl implements UserDetailsService {

	private final AuthenticAccountRepository accountRepository;

	/**
	 * 根据用户名查询用户角色、权限等信息
	 * 如果用户名无法查询到对应的用户，或者权限不满足，请直接抛出{@link UsernameNotFoundException}，勿返回null
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountRepository.findByUsername(username);
	}

}
