package cn.catguild.guild.domain.user;

import cn.catguild.guild.domain.user.entity.Account;
import cn.catguild.guild.infrastructure.persistence.CatPageQuery;
import cn.catguild.guild.infrastructure.persistence.user.entity.AccountDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Lionel
 * @date 2022-04-04 23:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountQuery extends CatPageQuery<AccountDO> {

	private String username;

}
