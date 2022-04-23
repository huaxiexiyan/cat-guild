package cn.catguild.guild.resource.user.request;

import lombok.Data;

/**
 * 请求分页
 *
 * @author Lionel
 * @date 2022-04-16 18:37
 */
@Data
public class AccountPageRequest {
	private Integer current;
	private Integer pageSize;
}
