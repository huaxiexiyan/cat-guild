package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.*;
import cn.catguild.guild.infrastructure.model.Entity;
import lombok.*;

/**
 * 账号
 *
 * @author xiyan
 * @date 2022-04-04 13:24
 */
@Setter
@Getter
@AllArgsConstructor
public class Account implements Entity{

	private AccountId id;

	private AccountUsername username;

	private AccountPassword password;

	private Telephone telephone;

	private Email email;

	private CatTime createTime;

}
