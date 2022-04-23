package cn.catguild.guild.resource.user;

import cn.catguild.guild.applicaiton.user.AccountApplicationService;
import cn.catguild.guild.applicaiton.user.command.AccountRegisterCommand;
import cn.catguild.guild.applicaiton.user.dto.AccountDTO;
import cn.catguild.guild.applicaiton.user.query.AccountPageQuery;
import cn.catguild.guild.applicaiton.user.query.AccountQuery;
import cn.catguild.guild.infrastructure.jaxrs.ApiPage;
import cn.catguild.guild.infrastructure.jaxrs.ApiResponse;
import cn.catguild.guild.infrastructure.persistence.CatPage;
import cn.catguild.guild.resource.user.converter.AccountVoAssembler;
import cn.catguild.guild.resource.user.request.AccountPageRequest;
import cn.catguild.guild.resource.user.request.AccountRegister;
import cn.catguild.guild.resource.user.vo.AccountVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户资源、对终端提供api接口
 * 可依赖于 基础设施层、应用层
 * <p>
 * 对客户端以Restful形式暴露资源，提供对用户资源{@link cn.catguild.guild.domain.user.entity.Account}的管理入口
 *
 * @author xiyan
 * @date 2020/3/6 20:52
 **/
@Slf4j
@CacheConfig(cacheNames = "resource.account")
@RequestMapping("/api/accounts")
@RestController
@AllArgsConstructor
public class AccountResource {

	/**
	 * 直接依赖-应用层
	 **/
	private AccountApplicationService service;
	private AccountVoAssembler accountVoAssembler;

	/**
	 * 注册账号
	 **/
	@PostMapping("/register")
	public ApiResponse<?> register(@RequestBody AccountRegister register) {
		AccountRegisterCommand command = new AccountRegisterCommand();
		return ApiResponse.status(service.register(command));
	}

	/**
	 * 忘记密码
	 **/
	@GetMapping("/reset-password")
	public ApiResponse<?> resetPassword() {
		return ApiResponse.ok();
	}

	/**
	 * 账号认证
	 **/
	@GetMapping("/authenticate")
	public ApiResponse<?> authenticate() {
		return ApiResponse.ok();
	}

	/**
	 * 注销账号
	 **/
	@PostMapping("/logout")
	public ApiResponse<?> logout() {
		return ApiResponse.ok();
	}

	/**
	 * 账号列表
	 **/
	@GetMapping("")
	public ApiResponse<ApiPage<AccountVO>> page(AccountPageRequest pageRequest) {
		AccountPageQuery pageQuery = accountVoAssembler.toCommand(pageRequest);
		CatPage<AccountDTO> search = service.search(pageQuery);
		ApiPage<AccountVO> page = new ApiPage<>(search);
		page.setList(accountVoAssembler.toVo(search.getList()));
		return ApiResponse.ok(page);
	}

	/**
	 * 当前登录账号信息
	 **/
	@GetMapping("/current")
	public ApiResponse<AccountDTO> currentAccount() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		AccountQuery query = new AccountQuery();
		query.setUsername(authentication.getName());
		List<AccountDTO> accounts = service.query(query);
		return ApiResponse.ok(accounts.get(0));
	}

}
