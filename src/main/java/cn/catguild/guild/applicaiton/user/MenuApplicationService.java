package cn.catguild.guild.applicaiton.user;

import cn.catguild.guild.applicaiton.user.command.MenuCreateCommand;
import cn.catguild.guild.applicaiton.user.command.MenuEditCommand;
import cn.catguild.guild.applicaiton.user.command.MenuRemoveCommand;
import cn.catguild.guild.applicaiton.user.converter.MenuDtoAssembler;
import cn.catguild.guild.applicaiton.user.dto.MenuTreeDTO;
import cn.catguild.guild.applicaiton.user.query.MenuQuery;
import cn.catguild.guild.applicaiton.util.CatTreeNode;
import cn.catguild.guild.domain.user.entity.Menu;
import cn.catguild.guild.domain.user.repository.MenuRepository;
import cn.catguild.guild.domain.user.type.MenuId;
import cn.catguild.guild.domain.user.type.MenuType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单应用
 *
 * @author xiyan
 * @date 2022-04-25 15:38
 */
@AllArgsConstructor
@Service
public class MenuApplicationService {

	private MenuRepository menuRepository;
	private MenuDtoAssembler menuDtoAssembler;


	/**
	 * 获取树形菜单
	 *
	 * @param command
	 * @return
	 */
	public List<MenuTreeDTO> queryMenuTree(MenuQuery command){
		List<Menu> menus = menuRepository.find(new MenuType(command.getType()));
		List<MenuTreeDTO> dto = menuDtoAssembler.toDto(menus);
		return CatTreeNode.merge(dto);
	}

	/**
	 * 创建菜单
	 *
	 * @param command 创建命令
	 * @return 是否创建成功
	 */
	public Boolean createMenu(MenuCreateCommand command){
		Menu menu = menuDtoAssembler.toDomain(command);
		return menuRepository.save(menu);
	}

	/**
	 * 编辑菜单
	 *
	 * @param command 编辑命令
	 * @return 是否编辑成功
	 */
	public Boolean editMenu(MenuEditCommand command){
		Menu menu = menuDtoAssembler.toDomain(command);
		return menuRepository.save(menu);
	}

	/**
	 * 移除菜单
	 *
	 * @param command 命令
	 * @return 是否移除成功
	 */
	public Boolean removeMenu(MenuRemoveCommand command){
		List<MenuId> menuIds = menuDtoAssembler.toDp(command.getIds());
		return menuRepository.delete(menuIds);
	}

}
