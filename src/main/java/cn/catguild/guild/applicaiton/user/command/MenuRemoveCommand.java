package cn.catguild.guild.applicaiton.user.command;

import lombok.Data;

import java.util.List;

/**
 * @author xiyan
 * @date 2022-04-25 15:42
 */
@Data
public class MenuRemoveCommand {
	/** 菜单id列表 **/
	private List<Long> ids;
}
