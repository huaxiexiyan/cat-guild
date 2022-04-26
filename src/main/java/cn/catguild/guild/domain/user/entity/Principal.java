package cn.catguild.guild.domain.user.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

/**
 * 委托人
 *
 * @author xiyan
 * @date 2022-04-04 21:34
 */
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
public class Principal extends CatUser {


}
