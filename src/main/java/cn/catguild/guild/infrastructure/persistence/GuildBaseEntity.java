package cn.catguild.guild.infrastructure.persistence;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiyan
 * @date 2022-04-04 08:59
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GuildBaseEntity extends BaseEntity {

	/**
	 * 公会id
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long guildId;

}
