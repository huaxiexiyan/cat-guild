package cn.catguild.guild.domain.user.type;

import cn.catguild.guild.infrastructure.model.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiyan
 * @date 2022-04-04 21:01
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class CatUserId implements ValueObject {
	private Long value;
}
