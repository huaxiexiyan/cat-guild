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

package cn.catguild.guild.resource;

import cn.catguild.guild.applicaiton.AccountApplicationService;
import cn.catguild.guild.domain.account.Account;
import cn.catguild.guild.domain.account.validation.AuthenticatedAccount;
import cn.catguild.guild.domain.account.validation.NotConflictAccount;
import cn.catguild.guild.domain.account.validation.UniqueAccount;
import cn.catguild.guild.infrastructure.jaxrs.ApiResponse;
import cn.catguild.guild.infrastructure.jaxrs.CommonResponse;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 用户资源
 * <p>
 * 对客户端以Restful形式暴露资源，提供对用户资源{@link Account}的管理入口
 *
 * @author icyfenix@gmail.com
 * @date 2020/3/6 20:52
 **/
@Path("/accounts")
@Component
@CacheConfig(cacheNames = "resource.account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

	@Inject
	private AccountApplicationService service;

	/**
	 * 根据用户名称获取用户详情
	 */
	@GET
	@Path("/current/user")
	public ApiResponse<Account> getCurrentUser() {
		return ApiResponse.ok(service.findAccountByUsername("icyfenix"));
	}

	/**
	 * 根据用户名称获取用户详情
	 */
	@GET
	@Path("/{username}")
	@Cacheable(key = "#username")
	public Account getUser(@PathParam("username") String username) {
		return service.findAccountByUsername(username);
	}

	/**
	 * 创建新的用户
	 */
	@POST
	@CacheEvict(key = "#user.username")
	public Response createUser(@Valid @UniqueAccount Account user) {
		return CommonResponse.op(() -> service.createAccount(user));
	}


	/**
	 * 更新用户信息
	 */
	@PUT
	@CacheEvict(key = "#user.username")
	public Response updateUser(@Valid @AuthenticatedAccount @NotConflictAccount Account user) {
		return CommonResponse.op(() -> service.updateAccount(user));
	}
}