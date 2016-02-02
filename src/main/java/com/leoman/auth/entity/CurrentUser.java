package com.leoman.auth.entity;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public final class CurrentUser {

	
	
	private Subject getSubject() {
		return SecurityUtils.getSubject();
	}
}
