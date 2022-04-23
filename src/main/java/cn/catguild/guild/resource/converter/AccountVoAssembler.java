package cn.catguild.guild.resource.converter;

import cn.catguild.guild.applicaiton.dto.AccountDTO;
import cn.catguild.guild.applicaiton.query.AccountPageQuery;
import cn.catguild.guild.resource.request.AccountPageRequest;
import cn.catguild.guild.resource.vo.AccountVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

/**
 * @author xiyan
 * @date 2022-04-23 12:43
 */
@Mapper(componentModel = MappingConstants.ComponentModel.JSR330,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountVoAssembler {

	Collection<AccountVO> toVo(Collection<AccountDTO> accountDTO);

	AccountPageQuery toCommand(AccountPageRequest pageRequest);
}
