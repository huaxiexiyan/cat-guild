package cn.catguild.guild.domain.user.entity;

import cn.catguild.guild.domain.user.type.ApiId;
import cn.catguild.guild.domain.user.type.ApiName;
import cn.catguild.guild.domain.user.type.ApiUrl;
import cn.catguild.guild.infrastructure.model.Entity;
import lombok.Getter;

/**
 * api接口实体
 *
 * @author xiyan
 * @date 2022-04-24 16:42
 */
@Getter
public class Api implements Entity {

	private ApiId id;

	private ApiName name;

	private ApiUrl url;

}
