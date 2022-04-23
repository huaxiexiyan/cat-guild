package cn.catguild.guild.infrastructure.persistence.user.entity;

import lombok.Data;

/**
 * 字典
 *
 * @author xiyan
 * @date 2022-04-04 11:12
 */
@Data
public class SysDictDO {

	private String code;

	private String boName;

	private String desc;

	private Integer codeNumber;

}
