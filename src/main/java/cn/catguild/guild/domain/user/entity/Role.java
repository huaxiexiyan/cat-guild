package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.PermissionId;
import cn.catguild.guild.domain.user.type.RoleId;
import cn.catguild.guild.domain.user.type.RoleName;
import cn.catguild.guild.infrastructure.model.Entity;
import lombok.Getter;

import java.util.List;

/**
 * 角色实体
 *
 * @author xiyan
 * @date 2022-04-24 16:41
 */
@Getter
public class Role implements Entity{

	private RoleId id;

	private RoleName name;

	/** 功能集 **/
	private List<PermissionId> permissionIds;

}
