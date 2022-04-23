package cn.catguild.guild.domain.user.type;

import cn.catguild.guild.infrastructure.model.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 职位
 *
 * @author Lionel
 * @date 2022-04-04 14:19
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class Position implements ValueObject{
	private String value;
}
