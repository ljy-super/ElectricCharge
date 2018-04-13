package com.electricharge.core.shiro.web;


import com.electricharge.core.shiro.entity.SysRole;
import com.electricharge.core.shiro.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linjiayong
 * @since 2017-08-24
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
	@Autowired
	ISysRoleService sysRoleService;

	@RequestMapping("getRole")
	public SysRole getRole(){
	return     sysRoleService.selectRoleByIdWithPermission((long)1);
	}

}
