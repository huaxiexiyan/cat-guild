package cn.catguild.guild.applicaiton.user.dto;

import cn.catguild.guild.applicaiton.util.CatTreeNode;
import lombok.Data;

import java.util.Collection;

/**
 * @author xiyan
 * @date 2022-04-25 17:37
 */
@Data
public class MenuTreeDTO implements CatTreeNode<MenuTreeDTO,Long> {

	private Long id;

	private Long parentId;

	private String name;

	private Integer type;

	private Collection<MenuTreeDTO> children;

}
