package cn.catguild.guild.applicaiton.dto;

import lombok.Data;
import org.mapstruct.Mapping;

/**
 * @author Lionel
 * @date 2022-04-16 10:27
 */
@Data
public class AccountDTO {

	private Long id;

	private String username;

	private String telephone;

	private String email;

	private Long createTime;

}
