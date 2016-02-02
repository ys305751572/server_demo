package com.leoman.auth.entity;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public final class CurrentUser {

	/**
	 * 获取当前用户
	 * @return
	 */
	public static Principal getCurrentUser() {
		return (Principal) getSubject().getPrincipal() ;
	}
	
	public static String getAccount() {
		return getCurrentUser().getUsername();
	}
	
	public static Long getId() {
		return getCurrentUser().getId();
	}
	
	protected static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
}
