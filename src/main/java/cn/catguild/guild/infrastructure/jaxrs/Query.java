package cn.catguild.guild.infrastructure.jaxrs;

import lombok.Data;

/**
 * @author xiyan
 * @date 2022-04-03 23:48
 */
@Data
public class Query {

	/** 当前页 **/
	private Integer current;

	/** 每页的数量 **/
	private Integer pageSize;

	/**  **/
	private String ascs;

	/**  **/
	private String descs;

}
