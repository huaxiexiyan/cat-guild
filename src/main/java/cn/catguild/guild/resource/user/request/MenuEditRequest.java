package cn.catguild.guild.resource.user.request;

import lombok.Data;

/**
 * @author xiyan
 * @date 2022-04-26 20:24
 */
@Data
public class MenuEditRequest {
	/** 主键id **/
	private Long id;
	/** 上级菜单id **/
	private Long parentId;
	/** 菜单名称 **/
	private String name;
	/** 菜单类型(1 菜单,2 按钮) **/
	private Integer type;
}
