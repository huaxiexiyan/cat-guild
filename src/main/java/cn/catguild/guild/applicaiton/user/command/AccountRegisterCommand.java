package cn.catguild.guild.applicaiton.user.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author xiyan
 * @date 2022-04-16 10:42
 */
@Data
public class AccountRegisterCommand {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

}
