package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.MenuId;
import cn.catguild.guild.domain.user.type.MenuName;
import cn.catguild.guild.domain.user.type.MenuType;
import cn.catguild.guild.infrastructure.model.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单表
 *
 * @author xiyan
 * @date 2022-04-24 16:43
 */
@Getter
@AllArgsConstructor
public class Menu implements Entity {
	private MenuId id;
	private MenuId parentId;
	private MenuName name;
	/** 按钮或菜单 **/
	private MenuType type;
}
