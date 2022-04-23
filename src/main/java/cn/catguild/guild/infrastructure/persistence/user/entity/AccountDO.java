package cn.catguild.guild.infrastructure.persistence.user.entity;

import cn.catguild.guild.infrastructure.persistence.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账号实体-其中只保留登录凭证
 * 查询 > 更新
 *
 * @author xiyan
 * @date 2022/4/3 23:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("account")
public class AccountDO extends BaseEntity {

	private String username;

	private String telephone;

	private String email;

	/**
	 * 密码字段不参与序列化（但反序列化是参与的）、不参与更新（但插入是参与的）
	 * 这意味着密码字段不会在获取对象（很多操作都会关联用户对象）的时候泄漏出去；
	 * 也意味着此时“修改密码”一类的功能无法以用户对象资源的接口来处理（因为更新对象时密码不会被更新），需要单独提供接口去完成
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

}
