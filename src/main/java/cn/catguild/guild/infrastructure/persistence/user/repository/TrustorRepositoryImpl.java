package cn.catguild.guild.infrastructure.persistence.user.repository;

import cn.catguild.guild.domain.user.entity.Principal;
import cn.catguild.guild.domain.user.repository.PrincipalRepository;

import javax.inject.Named;

/**
 * @author Lionel
 * @date 2022-04-04 21:42
 */
@Named
public class TrustorRepositoryImpl implements PrincipalRepository {

	@Override
	public void save(Principal trustor){

	}

}
