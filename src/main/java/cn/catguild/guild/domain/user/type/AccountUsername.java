package cn.catguild.guild.domain.user.type;

import cn.catguild.guild.infrastructure.model.ValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiyan
 * @date 2022-04-04 13:40
 */
@Getter
@AllArgsConstructor
public class AccountUsername implements ValueObject {

	private String value;

}
