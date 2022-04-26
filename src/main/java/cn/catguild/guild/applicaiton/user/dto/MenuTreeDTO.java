package cn.catguild.guild.applicaiton.user.dto;

import cn.catguild.guild.applicaiton.util.CatTreeNode;
import lombok.Data;

import java.util.Collection;

/**
 * @author Lionel
 * @date 2022-04-25 17:37
 */
@Data
public class MenuTreeDTO implements CatTreeNode<MenuTreeDTO,Long> {

	private Long id;

	private Long parentId;

	private Collection<MenuTreeDTO> children;

}
