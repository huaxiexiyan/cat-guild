package cn.catguild.guild.infrastructure.utility;

import javax.annotation.Nullable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author xiyan
 * @date 2022-04-23 23:10
 */
public class CatDateUtils {

	@Nullable
	public static LocalDateTime toLocalDateTime(Long epochMilli) {
		if (ObjectUtils.isEmpty(epochMilli)){
			return null;
		}
		return ZonedDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault()).toLocalDateTime();
	}

}
