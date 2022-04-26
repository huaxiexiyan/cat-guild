package cn.catguild.guild.domain.user.type;

import cn.catguild.guild.infrastructure.model.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiyan
 * @date 2022-04-25 13:45
 */
@Getter
@AllArgsConstructor
public class MenuName implements ValueObject {
	private String value;
}
