package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.AdventureLevel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

/**
 * 冒险家
 *
 * @author xiyan
 * @date 2022-04-04 13:36
 */
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
public class Adventurer extends CatUser{

	/** 冒险等级 **/
	private AdventureLevel level;

}
