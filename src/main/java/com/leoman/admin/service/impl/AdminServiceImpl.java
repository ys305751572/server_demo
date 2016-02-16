package com.leoman.admin.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;

import org.springframework.beans.factory.annotation.Autowired;

import com.leoman.admin.dao.AdminDAO;
import com.leoman.admin.entity.Admin;
import com.leoman.admin.service.IAdminService;
import com.leoman.baisc.service.impl.GenericManagerImpl;

public class AdminServiceImpl extends GenericManagerImpl<Admin, AdminDAO> implements IAdminService{

	@Autowired
	private AdminDAO dao;
	
	@Autowired
	private EntityManagerFactory factory;
	
	@Override
	public Admin findByUsername(String username) {
		
		EntityManager em = factory.createEntityManager();
		String sql = "select admin FROM Admin admin where admin.username = :username";
		return em.createQuery(sql,Admin.class).setFlushMode(FlushModeType.COMMIT).setParameter("username", username).getSingleResult();
	}
}
