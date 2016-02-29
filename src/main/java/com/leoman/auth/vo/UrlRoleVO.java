package com.leoman.auth.vo;

public class UrlRoleVO {

	private String roleName;
	
	private String url;
	
	public UrlRoleVO() {}
	
	public UrlRoleVO(String roleName,String url) {
		this.roleName = roleName;
		this.url = url;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
