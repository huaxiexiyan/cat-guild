package cn.catguild.guild.infrastructure.persistence.user.entity;

import cn.catguild.guild.infrastructure.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiyan
 * @date 2022-04-26 15:44
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuDO extends BaseEntity {
	private Long parentId;
	private String name;
	/** 按钮或菜单 **/
	private Integer type;
}
