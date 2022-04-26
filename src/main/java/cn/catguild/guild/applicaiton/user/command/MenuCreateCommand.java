package cn.catguild.guild.applicaiton.user.command;

import lombok.Data;

/**
 * @author xiyan
 * @date 2022-04-25 15:42
 */
@Data
public class MenuCreateCommand {
	/** 菜单名称 **/
	private String name;
	/** 菜单类型(1 菜单,2 按钮) **/
	private Integer type;
	/** 上级菜单id **/
	private Long parentId;
}
