package cn.catguild.guild.applicaiton.user.converter;

import cn.catguild.guild.applicaiton.user.dto.AccountDTO;
import cn.catguild.guild.applicaiton.user.query.AccountPageQuery;
import cn.catguild.guild.domain.user.entity.Account;
import cn.catguild.guild.domain.user.query.AccountDoQuery;
import org.mapstruct.*;

import java.util.Collection;

/**
 * @author Lionel
 * @date 2022-04-16 10:27
 */
@Mapper(componentModel = MappingConstants.ComponentModel.JSR330,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountDtoAssembler {

	AccountDoQuery toDoQuery(AccountPageQuery pageQuery);

	@Mappings({
		@Mapping(source = "id.value",target = "id"),
		@Mapping(source = "username.value",target = "username"),
		@Mapping(source = "telephone.value",target = "telephone"),
		@Mapping(source = "email.value",target = "email"),
		@Mapping(source = "createTime.value",target = "createTime")
	})
	AccountDTO toDto(Account account);

	Collection<AccountDTO> toDto(Collection<Account> list);

}
