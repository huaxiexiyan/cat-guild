package cn.catguild.guild.domain.user.repository;

import cn.catguild.guild.domain.user.entity.Menu;
import cn.catguild.guild.domain.user.type.MenuId;
import cn.catguild.guild.domain.user.type.MenuType;

import java.util.Collection;
import java.util.List;

/**
 * @author xiyan
 * @date 2022-04-25 15:47
 */
public interface MenuRepository {

	Boolean save(Menu menu);

	Boolean delete(Collection<MenuId> menuIds);

	List<Menu> find(MenuType menuType);

}
