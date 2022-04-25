package cn.catguild.guild.applicaiton.user;

import cn.catguild.guild.applicaiton.user.command.FunctionPointBindingCommand;
import cn.catguild.guild.applicaiton.user.command.PermissionDefineCommand;
import cn.catguild.guild.applicaiton.user.converter.AuthDtoAssembler;
import cn.catguild.guild.applicaiton.user.dto.FunctionPointDTO;
import cn.catguild.guild.applicaiton.user.query.FunctionPointCheckQuery;
import cn.catguild.guild.domain.user.entity.FunctionPoint;
import cn.catguild.guild.domain.user.entity.Permission;
import cn.catguild.guild.domain.user.repository.FunctionPointRepository;
import cn.catguild.guild.domain.user.repository.PermissionRepository;
import cn.catguild.guild.domain.user.service.AuthDomainService;
import cn.catguild.guild.domain.user.type.FunctionPointHrefKey;
import cn.catguild.guild.domain.user.type.PermissionGroupBit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 权限应用
 *
 * @author xiyan
 * @date 2022-04-25 13:57
 */
@AllArgsConstructor
@Service
public class AuthApplicationService {

	//private final AuthDtoAssembler authDtoAssembler;
	//private final FunctionPointRepository functionPointRepository;
	//private final PermissionRepository permissionRepository;
	//private final AuthDomainService authDomainService;
	//
	///**
	// * 绑定功能点
	// *
	// * @param command 绑定命令
	// * @return 是否绑定成功
	// */
	//public Boolean binding(FunctionPointBindingCommand command) {
	//	FunctionPoint functionPoint = authDtoAssembler.toDomain(command);
	//	functionPoint.getAuthPoint().binding();
	//	functionPointRepository.save(functionPoint);
	//	return true;
	//}
	//
	///**
	// * 过滤绑定过的功能点
	// *
	// * @param query 查询条件
	// * @return 绑定过的 hrefKey 集合
	// */
	//public FunctionPointDTO query(FunctionPointCheckQuery query){
	//	FunctionPointHrefKey hrefKey = new FunctionPointHrefKey();
	//	Collection<FunctionPoint> functionPoints = Collections.singleton(functionPointRepository.find(hrefKey));
	//	List<String> strings = functionPoints.stream()
	//		.map(FunctionPoint::getHrefKey)
	//		.map(FunctionPointHrefKey::toString)
	//		.toList();
	//	FunctionPointDTO dto = new FunctionPointDTO();
	//	dto.setHrefKeys(strings);
	//	return dto;
	//}
	//
	///**  **/
	//public Boolean definePermission(PermissionDefineCommand command){
	//	Permission permission = authDtoAssembler.toDomain(command);
	//	List<String> hrefKey = command.getHrefKey();
	//	List<FunctionPointHrefKey> hrefKeys = authDtoAssembler.toDp(hrefKey);
	//	Collection<FunctionPoint> functionPoints = functionPointRepository.find(hrefKeys);
	//	PermissionGroupBit groupBit = authDomainService.calculationPermissionGroupBit(functionPoints);
	//	permission.setGroupBit(groupBit);
	//	return permissionRepository.save(permission);
	//}

}
