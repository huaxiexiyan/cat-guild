package cn.catguild.guild.domain.user.type;

import lombok.Getter;

/**
 * @author xiyan
 * @date 2022-04-25 13:52
 */
@Getter
public class AuthorityPoint {
	/**
	 * 该权限点由idx和pos两个属性确保是全局唯一的权限点
	 * idx表示第几个Long型空间
	 */
	private Long idx;
	/** pos表示Long型对应的二进制数中所处的位置 **/
	private Long pos;

	/**
	 * 绑定权限点
	 */
	public void binding() {
		// 需要知道当前权限分配到什么位置了
	}

}
