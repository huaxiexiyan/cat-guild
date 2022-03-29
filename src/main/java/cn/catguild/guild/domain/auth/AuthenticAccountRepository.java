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

package cn.catguild.guild.domain.auth;

import cn.catguild.guild.domain.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 认证用户的数据仓库
 *
 * @author icyfenix@gmail.com
 * @date 2020/3/8 15:21
 **/
@Component
public class AuthenticAccountRepository {

	@Autowired
	private AccountRepository databaseUserRepo;

	public AuthenticAccount findByUsername(String username) {
		return new AuthenticAccount(Optional.ofNullable(databaseUserRepo.findByUsername(username))
			.orElseThrow(() -> new UsernameNotFoundException("用户" + username + "不存在")));
	}
}
