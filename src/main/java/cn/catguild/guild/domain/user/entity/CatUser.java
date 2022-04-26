package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.guild.type.GuildId;
import cn.catguild.guild.domain.user.type.*;
import cn.catguild.guild.infrastructure.type.CatTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * 用户
 *
 * @author xiyan
 * @date 2022-04-04 10:53
 */
@Setter(AccessLevel.PRIVATE)
@Data
public abstract class CatUser{

	/** 可以拥有唯一对应的账号 */
	private AccountId accountId;

	/** 所属公会id **/
	private GuildId guildId;

	private CatUserName name;

	private Avatar avatar;

	private Sex sex;

	private CatTime createTime;

}
