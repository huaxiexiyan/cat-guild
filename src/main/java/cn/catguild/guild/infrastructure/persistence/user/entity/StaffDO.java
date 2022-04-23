package cn.catguild.guild.infrastructure.persistence.user.entity;

import cn.catguild.guild.infrastructure.persistence.GuildBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 职员
 *
 * @author xiyan
 * @date 2022-04-04 09:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StaffDO extends GuildBaseEntity {

	private String name;

	private Integer sex;

	private String avatar;

}
