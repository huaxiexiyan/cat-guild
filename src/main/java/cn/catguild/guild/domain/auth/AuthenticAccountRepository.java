package cn.catguild.guild.domain.auth;

import cn.catguild.guild.domain.user.repository.AccountRepository;
import cn.catguild.guild.domain.user.type.AccountUsername;
import cn.catguild.guild.domain.user.type.Email;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 认证用户的数据仓库
 *
 * @author icyfenix@gmail.com
 * @date 2020/3/8 15:21
 **/
@AllArgsConstructor
@Repository
public class AuthenticAccountRepository {

	private final AccountRepository databaseUserRepo;

	public AuthenticAccount findByUsername(String username) {
		return new AuthenticAccount(databaseUserRepo.findOr(new AccountUsername(username), new Email(username))
			.orElseThrow(() -> new UsernameNotFoundException("用户" + username + "不存在")));
	}
}
