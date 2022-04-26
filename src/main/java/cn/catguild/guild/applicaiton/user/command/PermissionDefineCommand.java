package cn.catguild.guild.applicaiton.user.command;

import lombok.Data;

import java.util.List;

/**
 * @author xiyan
 * @date 2022-04-25 14:24
 */
@Data
public class PermissionDefineCommand {
	private String name;
	private List<String> hrefKey;
}
