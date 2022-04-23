package cn.catguild.guild.applicaiton;

import cn.catguild.guild.applicaiton.command.AccountRegisterCommand;
import cn.catguild.guild.applicaiton.converter.AccountDtoAssembler;
import cn.catguild.guild.applicaiton.dto.AccountDTO;
import cn.catguild.guild.applicaiton.query.AccountPageQuery;
import cn.catguild.guild.applicaiton.query.AccountQuery;
import cn.catguild.guild.domain.auth.AuthenticAccount;
import cn.catguild.guild.domain.user.entity.Account;
import cn.catguild.guild.domain.user.query.AccountDoQuery;
import cn.catguild.guild.domain.user.repository.AccountRepository;
import cn.catguild.guild.domain.user.type.AccountPassword;
import cn.catguild.guild.domain.user.type.AccountUsername;
import cn.catguild.guild.domain.user.type.Email;
import cn.catguild.guild.infrastructure.jaxrs.ApiResponse;
import cn.catguild.guild.infrastructure.persistence.CatPage;
import cn.catguild.guild.infrastructure.utility.Encryption;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户资源的应用服务接口
 * 职责就是编排领域服务、事务控制、并对外提供应用服务接口
 * 依赖于 基础设施层、领域层
 * <p>
 * pojo使用原则：
 * DTO 作为出参、Command、Query、Event对象 作为出参
 * DTOAssembler 把领域对象，转化为DTO
 *
 * @author icyfenix@gmail.com
 * @date 2020/3/10 17:46
 **/
@AllArgsConstructor
@Service
public class AccountApplicationService {

	private final AccountRepository repository;

	private final AccountDtoAssembler accountDtoAssembler;

	/**
	 * 注册账号
	 */
	@Transactional(rollbackFor = Exception.class)
	public Boolean register(AccountRegisterCommand command) {
		Account account = new Account(null, new AccountUsername(command.getUsername())
			, new AccountPassword(command.getPassword()), null, null, null);
		Account save = repository.save(account);
		return true;
	}

	/**
	 * 批量查询
	 *
	 * @param query 查询对象
	 * @return
	 */
	public List<AccountDTO> query(AccountQuery query) {
		Optional<Account> account = repository.find(new AccountUsername(query.getUsername()));
		Account account1 = account.orElseThrow(() -> new UsernameNotFoundException("用户" + query.getUsername() + "不存在"));
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUsername(account1.getUsername().getValue());
		List<AccountDTO> list = new ArrayList<>();
		list.add(accountDTO);
		return list;
	}

	/**
	 * 查询单个
	 *
	 * @param accountId
	 * @return
	 */
	public AccountDTO get(Long accountId) {
		return null;
	}

	/**
	 * 分页查询
	 *
	 * @param pageQuery
	 * @return
	 */
	public CatPage<AccountDTO> search(AccountPageQuery pageQuery) {
		CatPage<Account> queryPage = new CatPage<>(pageQuery);
		AccountDoQuery account = accountDtoAssembler.toDoQuery(pageQuery);
		CatPage<Account> page = repository.page(queryPage,account);
		CatPage<AccountDTO> catPage = new CatPage<>(page);
		catPage.setList(accountDtoAssembler.toDto(page.getList()));
		return catPage;
	}

}
