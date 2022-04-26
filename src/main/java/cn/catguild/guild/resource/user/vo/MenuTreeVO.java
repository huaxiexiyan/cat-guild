package cn.catguild.guild.resource.user.vo;

import cn.catguild.guild.applicaiton.user.dto.MenuTreeDTO;
import lombok.Data;

import java.util.Collection;

/**
 * @author xiyan
 * @date 2022-04-26 17:55
 */
@Data
public class MenuTreeVO {

	private Long id;

	private Long parentId;

	private Collection<MenuTreeDTO> children;

}
