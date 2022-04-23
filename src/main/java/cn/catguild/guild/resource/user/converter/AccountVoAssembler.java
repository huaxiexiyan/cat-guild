package cn.catguild.guild.resource.user.converter;

import cn.catguild.guild.applicaiton.user.dto.AccountDTO;
import cn.catguild.guild.applicaiton.user.query.AccountPageQuery;
import cn.catguild.guild.resource.user.request.AccountPageRequest;
import cn.catguild.guild.resource.user.vo.AccountVO;
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
