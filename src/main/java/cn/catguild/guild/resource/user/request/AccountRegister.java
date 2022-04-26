package cn.catguild.guild.resource.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author xiyan
 * @date 2022-04-16 10:21
 */
@Data
public class AccountRegister {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

}
