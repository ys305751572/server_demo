package com.leoman.auth.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.leoman.baisc.entity.BaseEntity;

@Entity
@Table(name = "tb_role")
public class Role extends BaseEntity{

	private static final long serialVersionUID = 1917751666014965900L;

	@Column(name = "name")
	private String name;
	
	@Column(name = "desc")
	private String desc;
	
	@ElementCollection
	@CollectionTable(name = "tb_role_authoritie")
	private List<String> authorities = new ArrayList<String>();
	
	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
