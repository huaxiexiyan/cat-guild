package cn.catguild.guild.applicaiton.user.dto;

import lombok.Data;
import org.mapstruct.Mapping;

/**
 * @author xiyan
 * @date 2022-04-16 10:27
 */
@Data
public class AccountDTO {

	private Long id;

	private String username;

	private String telephone;

	private String email;

	private Long createdTime;

	private Long lastModifiedTime;

}
