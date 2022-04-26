package cn.catguild.guild.infrastructure.utility;

import cn.catguild.guild.infrastructure.persistence.user.entity.AccountDO;
import org.springframework.ui.context.ThemeSource;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author xiyan
 * @date 2022-04-09 11:16
 */
public class ObjectUtils extends org.springframework.util.ObjectUtils {

	public static boolean isNotEmpty(@Nullable Object obj) {
		return !isEmpty(obj);
	}

	public static boolean notEquals(@Nullable Object o1, @Nullable Object o2) {
		return !nullSafeEquals(o1,o2);
	}
}
