package cn.catguild.guild.applicaiton.query;

import cn.catguild.guild.domain.user.entity.Account;
import cn.catguild.guild.infrastructure.persistence.CatPageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Lionel
 * @date 2022-04-16 18:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountPageQuery extends CatPageQuery<Account> {

	private String username;

}
