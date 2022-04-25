package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.AuthorityPoint;
import cn.catguild.guild.domain.user.type.FunctionPointHrefKey;
import cn.catguild.guild.domain.user.type.FunctionPointId;
import cn.catguild.guild.infrastructure.model.Entity;
import lombok.Getter;

/**
 * 功能点实体
 *
 * @author Lionel
 * @date 2022-04-24 16:43
 */
@Getter
public class FunctionPoint implements Entity {

	private FunctionPointId id;

	/** 关联id **/
	private FunctionPointHrefKey hrefKey;

	private AuthorityPoint authPoint;

}
