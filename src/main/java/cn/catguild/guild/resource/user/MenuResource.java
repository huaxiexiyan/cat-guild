package cn.catguild.guild.resource.user;

import cn.catguild.guild.applicaiton.user.MenuApplicationService;
import cn.catguild.guild.applicaiton.user.command.MenuCreateCommand;
import cn.catguild.guild.applicaiton.user.command.MenuEditCommand;
import cn.catguild.guild.applicaiton.user.command.MenuRemoveCommand;
import cn.catguild.guild.applicaiton.user.dto.AccountDTO;
import cn.catguild.guild.applicaiton.user.dto.MenuTreeDTO;
import cn.catguild.guild.applicaiton.user.query.AccountPageQuery;
import cn.catguild.guild.applicaiton.user.query.MenuQuery;
import cn.catguild.guild.infrastructure.jaxrs.ApiPage;
import cn.catguild.guild.infrastructure.jaxrs.ApiResponse;
import cn.catguild.guild.infrastructure.persistence.CatPage;
import cn.catguild.guild.resource.user.converter.MenuVoAssembler;
import cn.catguild.guild.resource.user.request.AccountPageRequest;
import cn.catguild.guild.resource.user.request.MenuAddRequest;
import cn.catguild.guild.resource.user.request.MenuEditRequest;
import cn.catguild.guild.resource.user.vo.AccountVO;
import cn.catguild.guild.resource.user.vo.MenuTreeVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author xiyan
 * @date 2022-04-26 17:51
 */
@Slf4j
@CacheConfig(cacheNames = "resource.menu")
@RequestMapping("/api/accounts")
@RestController
@AllArgsConstructor
public class MenuResource {

	private final MenuApplicationService menuApplicationService;
	private final MenuVoAssembler menuVoAssembler;

	@PostMapping("")
	public ApiResponse<?> create(MenuAddRequest addRequest) {
		MenuCreateCommand command = menuVoAssembler.toCommand(addRequest);
		Boolean result = menuApplicationService.createMenu(command);
		return ApiResponse.status(result);
	}

	@PutMapping("/{id}")
	public ApiResponse<?> edit(MenuEditRequest editRequest) {
		MenuEditCommand command = menuVoAssembler.toCommand(editRequest);
		Boolean result = menuApplicationService.editMenu(command);
		return ApiResponse.status(result);
	}

	@DeleteMapping("/{id}")
	public ApiResponse<?> remove(@PathVariable("id") Long id) {
		MenuRemoveCommand command = new MenuRemoveCommand();
		command.setIds(Collections.singletonList(id));
		Boolean result = menuApplicationService.removeMenu(command);
		return ApiResponse.status(result);
	}

	/**
	 * 账号列表
	 **/
	@GetMapping("/tree")
	public ApiResponse<List<MenuTreeVO>> tree() {
		MenuQuery query = new MenuQuery();
		query.setType(0);
		List<MenuTreeDTO> menuTree = menuApplicationService.queryMenuTree(query);
		List<MenuTreeVO> tree = menuVoAssembler.toVo(menuTree);
		return ApiResponse.ok(tree);
	}

}
