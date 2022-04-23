package cn.catguild.guild.domain.user.type;

import cn.catguild.guild.infrastructure.model.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lionel
 * @date 2022-04-04 13:56
 */
@Getter
public class CatTime implements ValueObject {
	private Long value;

	public CatTime(Long value) {
		if (value == null) {
			value = System.currentTimeMillis();
		}
		this.value = value;
	}
}
