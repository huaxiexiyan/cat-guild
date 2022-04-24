package cn.catguild.guild.domain.user.type;

import cn.catguild.guild.infrastructure.model.ValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Lionel
 * @date 2022-04-04 14:14
 */
@Getter
@AllArgsConstructor
public class AccountPassword implements ValueObject {

	private String value;

	public void encrypt(PasswordEncoder passwordEncoder) {
		this.value = passwordEncoder.encode(value);
	}

}
