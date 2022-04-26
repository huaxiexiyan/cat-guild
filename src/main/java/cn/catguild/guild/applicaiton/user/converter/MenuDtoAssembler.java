package cn.catguild.guild.applicaiton.user.converter;

import cn.catguild.guild.applicaiton.user.command.MenuCreateCommand;
import cn.catguild.guild.applicaiton.user.command.MenuEditCommand;
import cn.catguild.guild.applicaiton.user.command.MenuRemoveCommand;
import cn.catguild.guild.applicaiton.user.dto.MenuTreeDTO;
import cn.catguild.guild.domain.user.entity.Menu;
import cn.catguild.guild.domain.user.type.MenuId;

import java.util.List;

/**
 *
 * @author Lionel
 * @date 2022-04-25 15:48
 */
public interface MenuDtoAssembler {

	Menu toDomain(MenuCreateCommand command);

	Menu toDomain(MenuEditCommand command);

	List<MenuId> toDp(MenuRemoveCommand command);

	MenuTreeDTO toDto(Menu menu);

	List<MenuTreeDTO> toDto(List<Menu> menus);

}
