package com.leoman.auth.server;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.leoman.admin.entity.Admin;
import com.leoman.admin.service.IAdminService;
import com.leoman.auth.entity.ShiroUser;

@Named("customAuthoringRealm")
public class CustomAuthoringRealm extends AuthorizingRealm {

	@Autowired
	private IAdminService adminService;
	
	// 前线获取
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		
		// TODO	 根据用户信息查找用户所有权限
		
		List<String> authorities = new ArrayList<String>();
		SimpleAuthorizationInfo result = new SimpleAuthorizationInfo();
		result.addStringPermissions(authorities);
		return result;
	}

	// 身份验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken toToken = null;
		if(token instanceof UsernamePasswordToken) {
			toToken = (UsernamePasswordToken) token;
		}
		Admin admin = findAdmin((String) toToken.getPrincipal());
		
		ShiroUser shiroUser = new ShiroUser(admin.getId(),admin.getUsername(),admin.getPassword());
		SimpleAuthenticationInfo result = new SimpleAuthenticationInfo(shiroUser, admin.getPassword(), getName());
		
		return result;
	}

	private Admin findAdmin(String username) {
		return adminService.findByUsername(username);
	}
}
