package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.*;
import cn.catguild.guild.infrastructure.model.Entity;
import cn.catguild.guild.infrastructure.type.CatTime;
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

	/** 账户id **/
	private AccountId id;
	/** 账户名（唯一） **/
	private AccountUsername username;
	/** 密码 **/
	private AccountPassword password;
	/** 绑定手机（唯一） **/
	private Telephone telephone;
	/** 绑定邮箱（唯一） **/
	private Email email;
	/** 账户创建时间 **/
	private CatTime createdTime;
	/** 账户最后修改时间 **/
	private CatTime lastModifiedTime;

}
