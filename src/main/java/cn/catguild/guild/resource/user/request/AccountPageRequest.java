package cn.catguild.guild.resource.user.request;

import cn.catguild.guild.resource.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 请求分页
 *
 * @author xiyan
 * @date 2022-04-16 18:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountPageRequest extends PageRequest {

	private String username;

}
