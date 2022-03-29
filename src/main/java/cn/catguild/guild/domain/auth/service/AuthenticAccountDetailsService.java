/*
 * Copyright 2012-2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. More information from:
 *
 *        https://github.com/fenixsoft
 */

package cn.catguild.guild.domain.auth.service;

import cn.catguild.guild.domain.auth.AuthenticAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 认证用户信息查询服务（最终被spring security框架调用，来加载用户信息）
 * <p>
 * {@link UserDetailsService}接口定义了从外部（数据库、LDAP，任何地方）根据用户名查询到
 */
@Named
public class AuthenticAccountDetailsService implements UserDetailsService {

	@Inject
	private AuthenticAccountRepository accountRepository;

	/**
	 * 根据用户名查询用户角色、权限等信息
	 * 如果用户名无法查询到对应的用户，或者权限不满足，请直接抛出{@link UsernameNotFoundException}，勿返回null
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountRepository.findByUsername(username);
	}

}
