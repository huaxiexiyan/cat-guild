package cn.catguild.guild.domain.user.repository;

import cn.catguild.guild.domain.user.entity.FunctionPoint;
import cn.catguild.guild.domain.user.type.FunctionPointHrefKey;

import java.util.Collection;

/**
 * @author xiyan
 * @date 2022-04-25 14:08
 */
public interface FunctionPointRepository {

	void save(FunctionPoint functionPoint);

	FunctionPoint find(FunctionPointHrefKey hrefKey);
	Collection<FunctionPoint> find(Collection<FunctionPointHrefKey> hrefKeys);
}
