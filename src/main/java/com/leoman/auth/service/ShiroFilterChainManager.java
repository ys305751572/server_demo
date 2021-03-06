package com.leoman.auth.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.leoman.auth.vo.UrlAuthorityVO;

@Named("shiroFilterChainManager")
public class ShiroFilterChainManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShiroFilterChainManager.class);

	@Inject
	private DefaultFilterChainManager filterChainManager;

	@Inject
	private SecurityAccessService securityAccessService;

	private Map<String, NamedFilterList> defaultFilterChains;

	// @PostConstruct
	public void init() {
		defaultFilterChains = new LinkedHashMap<String, NamedFilterList>(filterChainManager.getFilterChains());
		LOGGER.info("defaultFilterChains:{}", defaultFilterChains);
	}

	// @PostConstruct
	public void initFilterChain() {
		List<UrlAuthorityVO> results = securityAccessService.findUrlAccessResource();
		LOGGER.info("initFilterChain:{}", results);
		initFilterChains(results);
	}

	public void initFilterChains(List<UrlAuthorityVO> urlAccessResources) {
		// 1、首先删除以前老的filter chain并注册默认的
		filterChainManager.getFilterChains().clear();
		if (defaultFilterChains != null) {
			filterChainManager.getFilterChains().putAll(defaultFilterChains);
		}
		
		if (!urlAccessResources.isEmpty()) {
			// 2、循环URL Filter 注册filter chain
			for (UrlAuthorityVO urlAuthority : urlAccessResources) {
				String url = urlAuthority.getUrl();
				LOGGER.info("roles:{},permissions:{}",urlAuthority.getRoles(),urlAuthority.getResources());
				if (StringUtils.hasText(url)) {
					// 注册roles filter
					if (!urlAuthority.getRoles().isEmpty()) {
                        listToString(urlAuthority.getRoles());
						filterChainManager.addToChain(url, "anyRole", listToString(urlAuthority.getRoles()));
					}
					// 注册perms filter
//					if (!urlAuthority.getPermissions().isEmpty()) {
//						filterChainManager.addToChain(url, "perms", listToString(urlAuthority.getPermissions()));
//					}
				}
			}
		}
		filterChainManager.addToChain("/**", "authc");
		LOGGER.info("filterChain:{}", filterChainManager.getFilterChains());
	}

    private String listToString(Collection<String> elements) {
        StringBuilder allRoles = new StringBuilder();
        for (String element : elements) {
            allRoles.append(element).append(",");
        }
        return allRoles.substring(0, allRoles.length() - 1);
    }

}
