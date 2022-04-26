package cn.catguild.guild.domain.user.repository;

import cn.catguild.guild.domain.user.entity.Principal;

/**
 * @author xiyan
 * @date 2022-04-04 21:42
 */
public interface PrincipalRepository {

	void save(Principal trustor);

}
