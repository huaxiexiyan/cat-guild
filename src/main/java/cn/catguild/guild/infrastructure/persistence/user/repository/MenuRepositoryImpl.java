package cn.catguild.guild.infrastructure.persistence.user.repository;

import cn.catguild.guild.domain.user.entity.Menu;
import cn.catguild.guild.domain.user.repository.MenuRepository;
import cn.catguild.guild.domain.user.type.MenuId;
import cn.catguild.guild.domain.user.type.MenuType;
import cn.catguild.guild.infrastructure.persistence.user.converter.MenuDoConverter;
import cn.catguild.guild.infrastructure.persistence.user.entity.MenuDO;
import cn.catguild.guild.infrastructure.persistence.user.mapper.MenuMapper;
import cn.catguild.guild.infrastructure.utility.ObjectUtils;
import com.alibaba.druid.sql.ast.expr.SQLHexExpr;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author xiyan
 * @date 2022-04-26 15:45
 */
@Slf4j
@Repository
@AllArgsConstructor
public class MenuRepositoryImpl implements MenuRepository {

	private final MenuMapper menuMapper;
	private final MenuDoConverter menuDoConverter;

	@Override
	public Boolean save(Menu menu) {
		MenuDO menuDO = menuDoConverter.toDo(menu);
		int result;
		if (ObjectUtils.isNotEmpty(menuDO.getId())) {
			result = menuMapper.updateById(menuDO);
		} else {
			result = menuMapper.insert(menuDO);
		}
		return SqlHelper.retBool(result);
	}

	@Override
	public Boolean delete(Collection<MenuId> menuIds) {
		List<Long> longs = menuIds.stream().map(MenuId::getValue).toList();
		int result = menuMapper.deleteBatchIds(longs);
		return SqlHelper.retBool(result);
	}

	@Override
	public List<Menu> find(MenuType menuType) {
		LambdaQueryWrapper<MenuDO> queryWrapper = Wrappers.<MenuDO>lambdaQuery()
			.eq(MenuDO::getType, menuType.getValue());
		List<MenuDO> menus = menuMapper.selectList(queryWrapper);
		return menuDoConverter.toDomain(menus);
	}
}
