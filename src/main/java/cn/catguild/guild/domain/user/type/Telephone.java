package cn.catguild.guild.domain.user.type;

import cn.catguild.guild.infrastructure.model.ValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ValidationException;
import java.util.Arrays;

/**
 * @author xiyan
 * @date 2022-04-04 13:38
 */
@Getter
public class Telephone implements ValueObject{

	private final String value;

	public Telephone(String value) {
		//if (value == null) {
		//	throw new ValidationException("value不能为空");
		//} else if (isValid(value)) {
		//	throw new ValidationException("value格式错误");
		//}
		this.value = value;
	}

	public String getAreaCode() {
		for (int i = 0; i < value.length(); i++) {
			String prefix = value.substring(0, i);
			if (isAreaCode(prefix)) {
				return prefix;
			}
		}
		return null;
	}

	private static boolean isAreaCode(String prefix) {
		String[] areas = new String[]{"0571", "021", "010"};
		return Arrays.asList(areas).contains(prefix);
	}

	public static boolean isValid(String value) {
		String pattern = "^0?[1-9]{2,3}-?\\d{8}$";
		return value.matches(pattern);
	}

}
