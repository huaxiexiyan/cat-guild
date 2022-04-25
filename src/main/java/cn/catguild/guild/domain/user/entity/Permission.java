package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.PermissionGroupBit;
import cn.catguild.guild.domain.user.type.PermissionId;
import cn.catguild.guild.domain.user.type.PermissionName;
import cn.catguild.guild.infrastructure.model.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * 权限集
 *
 * @author xiyan
 * @date 2022-04-25 13:41
 */
@Getter
public class Permission implements Entity {

	private PermissionId id;

	private PermissionName name;

	@Setter
	private PermissionGroupBit groupBit;

}
