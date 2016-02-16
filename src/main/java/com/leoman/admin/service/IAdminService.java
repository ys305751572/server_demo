package com.leoman.admin.service;

import com.leoman.admin.entity.Admin;
import com.leoman.baisc.service.GenericManager;

public interface IAdminService extends GenericManager<Admin>{

	public Admin findByUsername(String username);
}
 