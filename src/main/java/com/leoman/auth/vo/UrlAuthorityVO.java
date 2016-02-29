package com.leoman.auth.vo;

import java.util.ArrayList;
import java.util.List;

public class UrlAuthorityVO {

	private String url;
	
	private List<String> roles = new ArrayList<String>();
	
	private List<String> resources = new ArrayList<String>();

	public void addRole(String roleName) {
		roles.add(roleName);
	}

	public void addResource(String resource) {
		this.resources.add(resource);
	}
	
	public UrlAuthorityVO(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}

}
