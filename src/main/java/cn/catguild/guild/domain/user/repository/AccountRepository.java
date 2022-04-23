package cn.catguild.guild.domain.user.repository;

import cn.catguild.guild.domain.user.entity.Account;
import cn.catguild.guild.domain.user.query.AccountDoQuery;
import cn.catguild.guild.domain.user.type.AccountId;
import cn.catguild.guild.domain.user.type.AccountUsername;
import cn.catguild.guild.domain.user.type.Email;
import cn.catguild.guild.infrastructure.persistence.CatPage;

import java.util.Optional;

/**
 * 仓储服务-
 * 依赖 基础设施层
 *
 * @author Lionel
 * @date 2022-04-04 21:42
 */
public interface AccountRepository {

	Account save(Account account);

	void remove(AccountId accountId);

	CatPage<Account> page(CatPage<Account> page, AccountDoQuery doQuery);

	Optional<Account> findOr(AccountUsername username, Email email);

	Optional<Account> find(AccountUsername username);


}
