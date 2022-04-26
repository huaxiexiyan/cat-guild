package cn.catguild.guild.applicaiton.user.converter;

import cn.catguild.guild.applicaiton.user.command.MenuCreateCommand;
import cn.catguild.guild.applicaiton.user.command.MenuEditCommand;
import cn.catguild.guild.applicaiton.user.command.MenuRemoveCommand;
import cn.catguild.guild.applicaiton.user.dto.MenuTreeDTO;
import cn.catguild.guild.domain.user.entity.Menu;
import cn.catguild.guild.domain.user.type.MenuId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 *
 * @author xiyan
 * @date 2022-04-25 15:48
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuDtoAssembler {

	@Mapping(source = "parentId",target = "parentId.value")
	@Mapping(source = "name",target = "name.value")
	@Mapping(source = "type",target = "type.value")
	Menu toDomain(MenuCreateCommand command);

	@Mapping(source = "id",target = "id.value")
	@Mapping(source = "parentId",target = "parentId.value")
	@Mapping(source = "name",target = "name.value")
	@Mapping(source = "type",target = "type.value")
	Menu toDomain(MenuEditCommand command);

	@Mapping(source = ".",target = "value")
	MenuId toDp(Long id);

	List<MenuId> toDp(List<Long> ids);

	@Mapping(source = "id.value",target = "id")
	@Mapping(source = "parentId.value",target = "parentId")
	@Mapping(source = "name.value",target = "name")
	@Mapping(source = "type.value",target = "type")
	MenuTreeDTO toDto(Menu menu);

	List<MenuTreeDTO> toDto(List<Menu> menus);


}
