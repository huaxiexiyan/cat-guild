package cn.catguild.guild.resource.user.request;

import lombok.Data;

/**
 * @author xiyan
 * @date 2022-04-26 18:02
 */
@Data
public class MenuAddRequest {
	/** 菜单名称 **/
	private String name;
	/** 菜单类型(1 菜单,2 按钮) **/
	private Integer type;
	/** 上级菜单id **/
	private Long parentId;
}
