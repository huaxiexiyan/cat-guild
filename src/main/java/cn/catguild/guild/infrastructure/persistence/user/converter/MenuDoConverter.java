package cn.catguild.guild.infrastructure.persistence.user.converter;

import cn.catguild.guild.domain.user.entity.Menu;
import cn.catguild.guild.infrastructure.persistence.user.entity.MenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author xiyan
 * @date 2022-04-26 17:35
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuDoConverter {

	@Mapping(source = "id.value",target = "id")
	@Mapping(source = "parentId.value",target = "parentId")
	@Mapping(source = "name.value",target = "name")
	@Mapping(source = "type.value",target = "type")
	MenuDO toDo(Menu menu);

	@Mapping(source = "id",target = "id.value")
	@Mapping(source = "parentId",target = "parentId.value")
	@Mapping(source = "name",target = "name.value")
	@Mapping(source = "type",target = "type.value")
	Menu toDomain(MenuDO menu);

	List<Menu> toDomain(List<MenuDO> menus);

}
