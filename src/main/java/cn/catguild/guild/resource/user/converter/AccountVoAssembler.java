package cn.catguild.guild.resource.user.converter;

import cn.catguild.guild.applicaiton.user.dto.AccountDTO;
import cn.catguild.guild.applicaiton.user.query.AccountPageQuery;
import cn.catguild.guild.resource.user.request.AccountPageRequest;
import cn.catguild.guild.resource.user.vo.AccountVO;
import org.mapstruct.*;

import java.util.Collection;

/**
 * @author xiyan
 * @date 2022-04-23 12:43
 */
@Mapper(componentModel = MappingConstants.ComponentModel.JSR330,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountVoAssembler {

	@Mapping(target = "createdTime",expression = "java(cn.catguild.guild.infrastructure.utility.CatDateUtils.toLocalDateTime(dto.getCreatedTime()))")
	@Mapping(target = "lastModifiedTime",expression = "java(cn.catguild.guild.infrastructure.utility.CatDateUtils.toLocalDateTime(dto.getLastModifiedTime()))")
	AccountVO toVo(AccountDTO dto);

    Collection<AccountVO> toVo(Collection<AccountDTO> dtoCollection);

	AccountPageQuery toCommand(AccountPageRequest pageRequest);
}
