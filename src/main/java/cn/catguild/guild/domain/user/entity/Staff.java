package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.AccountId;
import cn.catguild.guild.domain.user.type.Position;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

/**
 * 公会职员
 *
 * @author xiyan
 * @date 2022-04-04 13:25
 */
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
public class Staff extends CatUser {

	/** 职务 **/
	private Position position;

}
