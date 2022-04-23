package cn.catguild.guild.infrastructure.persistence.user.converter;

import cn.catguild.guild.domain.user.entity.Account;
import cn.catguild.guild.infrastructure.persistence.user.entity.AccountDO;
import org.mapstruct.*;

import java.util.Collection;

/**
 * @author xiyan
 * @date 2022-04-04 23:57
 */
@Mapper(componentModel = MappingConstants.ComponentModel.JSR330,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountDoConverter{

	@Mappings({
		@Mapping(source = "id.value",target = "id"),
		@Mapping(source = "username.value",target = "username"),
		@Mapping(source = "telephone.value",target = "telephone"),
		@Mapping(source = "email.value",target = "email"),
		@Mapping(source = "password.value",target = "password"),
		@Mapping(source = "createdTime.value",target = "createdTime"),
		@Mapping(source = "lastModifiedTime.value",target = "lastModifiedTime")
	})
	AccountDO toDo(Account account);

	@Mappings({
		@Mapping(source = "id",target = "id.value"),
		@Mapping(source = "username",target = "username.value"),
		@Mapping(source = "telephone",target = "telephone.value"),
		@Mapping(source = "email",target = "email.value"),
		@Mapping(source = "password",target = "password.value"),
		@Mapping(source = "createdTime",target = "createdTime.value"),
		@Mapping(source = "lastModifiedTime",target = "lastModifiedTime.value")
	})
	Account toDomain(AccountDO orderDO);

	Collection<Account> toDomain(Collection<AccountDO> list);

}
