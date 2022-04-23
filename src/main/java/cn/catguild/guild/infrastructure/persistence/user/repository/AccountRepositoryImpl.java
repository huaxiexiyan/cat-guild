package cn.catguild.guild.infrastructure.persistence.user.repository;

import cn.catguild.guild.domain.user.entity.Account;
import cn.catguild.guild.domain.user.query.AccountDoQuery;
import cn.catguild.guild.domain.user.repository.AccountRepository;
import cn.catguild.guild.domain.user.type.AccountId;
import cn.catguild.guild.domain.user.type.AccountUsername;
import cn.catguild.guild.domain.user.type.Email;
import cn.catguild.guild.infrastructure.persistence.CatPage;
import cn.catguild.guild.infrastructure.persistence.user.converter.AccountDoConverter;
import cn.catguild.guild.infrastructure.persistence.user.entity.AccountDO;
import cn.catguild.guild.infrastructure.persistence.user.mapper.AccountMapper;
import cn.catguild.guild.infrastructure.utility.Condition;
import cn.catguild.guild.infrastructure.utility.ObjectUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

/**
 * @author Lionel
 * @date 2022-04-04 21:42
 */
@AllArgsConstructor
@Repository
public class AccountRepositoryImpl implements AccountRepository {

	private final AccountMapper baseMapper;

	private final AccountDoConverter baseConverter;

	@Override
	public Account save(Account aggregate) {
		if (aggregate.getId() != null && aggregate.getId().getValue() > 0) {
			// update
			AccountDO accountDO = baseConverter.toDo(aggregate);
			baseMapper.updateById(accountDO);
		} else {
			// insert
			AccountDO orderDO = baseConverter.toDo(aggregate);
			baseMapper.insert(orderDO);
			aggregate = baseConverter.toDomain(orderDO);
		}
		return aggregate;
	}

	@Override
	public void remove(@Nonnull AccountId accountId) {
		baseMapper.deleteById(accountId.getValue());
	}

	@Override
	public CatPage<Account> page(@Nonnull CatPage<Account> page,@Nonnull AccountDoQuery doQuery) {
		LambdaQueryWrapper<AccountDO> queryWrapper = Wrappers.lambdaQuery();
		if (ObjectUtils.isNotEmpty(doQuery.getUsername())){
			queryWrapper.eq(AccountDO::getUsername,doQuery.getUsername());
		}
		// IPage 做为mp 的对象，需要将其留在 基础设施
		IPage<AccountDO> resultPage = baseMapper.selectPage(Condition.getIPage(page), queryWrapper);
		CatPage<Account> catPage = Condition.getCatPage(resultPage);
		catPage.setList(baseConverter.toDomain(resultPage.getRecords()));
		return catPage;
	}

	@Override
	public Optional<Account> findOr(@Nonnull AccountUsername username,@Nonnull Email email) {
		Wrapper<AccountDO> queryWrapper = Wrappers.<AccountDO>lambdaQuery()
			.eq(AccountDO::getUsername, username.getValue())
			.or()
			.eq(AccountDO::getEmail, email.getValue());
		List<AccountDO> result = baseMapper.selectList(queryWrapper);
		if (ObjectUtils.isEmpty(result)) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(baseConverter.toDomain(result.get(0)));
		}
	}

	@Override
	public Optional<Account> find(@Nonnull AccountUsername username) {
		Wrapper<AccountDO> queryWrapper = Wrappers.<AccountDO>lambdaQuery()
			.eq(AccountDO::getUsername, username.getValue());
		List<AccountDO> result = baseMapper.selectList(queryWrapper);
		if (ObjectUtils.isEmpty(result)) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(baseConverter.toDomain(result.get(0)));
		}
	}

}
