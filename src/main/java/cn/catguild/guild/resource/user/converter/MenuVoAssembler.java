package cn.catguild.guild.resource.user.converter;

import cn.catguild.guild.applicaiton.user.command.MenuCreateCommand;
import cn.catguild.guild.applicaiton.user.command.MenuEditCommand;
import cn.catguild.guild.applicaiton.user.dto.MenuTreeDTO;
import cn.catguild.guild.resource.user.request.MenuAddRequest;
import cn.catguild.guild.resource.user.request.MenuEditRequest;
import cn.catguild.guild.resource.user.vo.MenuTreeVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author xiyan
 * @date 2022-04-26 17:54
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuVoAssembler {

	List<MenuTreeVO> toVo(List<MenuTreeDTO> menuTree);

	MenuCreateCommand toCommand(MenuAddRequest addRequest);

	MenuEditCommand toCommand(MenuEditRequest editRequest);
}
