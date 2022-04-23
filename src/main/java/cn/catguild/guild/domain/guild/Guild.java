package cn.catguild.guild.domain.guild;

import cn.catguild.guild.domain.guild.type.GuildId;
import cn.catguild.guild.domain.guild.type.GuildName;
import cn.catguild.guild.domain.guild.type.GuildNumber;
import cn.catguild.guild.infrastructure.persistence.GuildBaseEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

/**
 * 公会实体
 *
 * @author xiyan
 * @date 2022-04-04 09:16
 */
@Setter(AccessLevel.PRIVATE)
@Data
public class Guild{

	/** 唯一标识 **/
	private GuildId guildId;

	/** 唯一编号 **/
	private GuildNumber number;

	private GuildName name;


}
