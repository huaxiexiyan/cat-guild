package cn.catguild.guild.applicaiton.user.converter;

import cn.catguild.guild.applicaiton.user.command.FunctionPointBindingCommand;
import cn.catguild.guild.applicaiton.user.command.PermissionDefineCommand;
import cn.catguild.guild.domain.user.entity.FunctionPoint;
import cn.catguild.guild.domain.user.entity.Permission;
import cn.catguild.guild.domain.user.type.FunctionPointHrefKey;

import java.util.List;

/**
 * @author Lionel
 * @date 2022-04-25 14:07
 */
public interface AuthDtoAssembler {

	FunctionPoint toDomain(FunctionPointBindingCommand command);

	List<FunctionPointHrefKey> toDp(List<String> hrefKey);

	Permission toDomain(PermissionDefineCommand command);

}
