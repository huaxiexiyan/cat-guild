package cn.catguild.guild.infrastructure.persistence.user.entity;

import cn.catguild.guild.infrastructure.persistence.GuildBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 冒险家实体
 *
 * @author xiyan
 * @date 2022-04-04 10:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdventurerDO extends GuildBaseEntity {

	private String name;

	private Integer sex;

	private String avatar;

}
