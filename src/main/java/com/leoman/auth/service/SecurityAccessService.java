package com.leoman.auth.service;

import java.util.List;

import com.leoman.auth.vo.UrlAuthorityVO;
import com.leoman.auth.vo.UrlRoleVO;

public interface SecurityAccessService {

	public List<String> findRolesByUserId(Long userId);
	
	public List<UrlAuthorityVO> findUrlAccessResource();
	
	public List<UrlRoleVO> findUrlRole();
}
