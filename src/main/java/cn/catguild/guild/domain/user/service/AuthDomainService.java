package cn.catguild.guild.domain.user.service;

import cn.catguild.guild.domain.user.entity.FunctionPoint;
import cn.catguild.guild.domain.user.type.AuthorityPoint;
import cn.catguild.guild.domain.user.type.PermissionGroupBit;
import cn.catguild.guild.infrastructure.utility.JsonUtils;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lionel
 * @date 2022-04-25 14:32
 */
public class AuthDomainService {

	public PermissionGroupBit calculationPermissionGroupBit(@Nonnull Collection<FunctionPoint> functionPoints) {
		StringBuilder sb = new StringBuilder();
		Map<Long, Long> collect = functionPoints.stream()
			.map(FunctionPoint::getAuthPoint)
			.collect(Collectors.toMap(AuthorityPoint::getIdx, AuthorityPoint::getPos, (pos1, pos2) -> pos1 | pos2));
		//String json = JsonUtils.toJsonString(collect);
		// {idx,long1,id2,long2}
		return new PermissionGroupBit();
	}

}
