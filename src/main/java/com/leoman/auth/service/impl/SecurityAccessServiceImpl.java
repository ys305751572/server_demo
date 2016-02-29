package com.leoman.auth.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import com.leoman.auth.entity.UrlAccessReource;
import com.leoman.auth.service.SecurityAccessService;
import com.leoman.auth.vo.UrlAuthorityVO;
import com.leoman.auth.vo.UrlRoleVO;

@Service
public class SecurityAccessServiceImpl implements SecurityAccessService{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<String> findRolesByUserId(Long userId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UrlAuthorityVO> findUrlAccessResource() {
		
		StringBuffer jpql = new StringBuffer("select new com.leoman.auth.vo.UrlAuthorityVO(_resource.url) ");
		jpql = fromResourceAssigment(jpql);
		List<UrlAuthorityVO> list = em.createQuery(jpql.toString()).setParameter("resourceType", UrlAccessReource.class).getResultList();
		if(list != null && !list.isEmpty())
		for (UrlAuthorityVO urlAuthority : list) {
			for (UrlRoleVO urlRole : findUrlRole()) {
				if(urlRole.getUrl().equals(urlAuthority.getUrl())) {
					urlAuthority.addRole(urlRole.getRoleName());
				}
			}
		}
		return list;
	}

	private StringBuffer fromResourceAssigment(StringBuffer jpql) {
		jpql.append(" from ResourceAssignment a join a.role _role join a.resource _resource where TYPE(_resource) = :resourceType");
		return jpql;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UrlRoleVO> findUrlRole() {
		StringBuffer jpql = new StringBuffer("select new com.leoman.auth.vo.UrlRoleVO(_resource.url,_authority.name)");
		jpql = fromResourceAssigment(jpql);
		return em.createQuery(jpql.toString()).setParameter("resourceType", UrlAccessReource.class).getResultList();
	}
}
