package cn.catguild.guild.infrastructure.type;

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
		this.value = value;
	}
}
