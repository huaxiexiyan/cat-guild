package cn.catguild.guild.resource.user.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xiyan
 * @date 2022-04-23 11:59
 */
@Data
public class AccountVO {

	private String id;

	private String username;

	private String telephone;

	private String email;

	private LocalDateTime createdTime;

	private LocalDateTime lastModifiedTime;

}
