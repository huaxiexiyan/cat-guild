package cn.catguild.guild.domain.user.repository;

import cn.catguild.guild.domain.user.entity.Permission;

/**
 * @author xiyan
 * @date 2022-04-25 14:26
 */
public interface PermissionRepository {
	boolean save(Permission permission);
}
