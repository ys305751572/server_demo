package com.leoman.role.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.leoman.baisc.entity.BaseEntity;

@Entity
@Table(name="t_role")
public class Role extends BaseEntity{

	private static final long serialVersionUID = 5330628981781350873L;


	/** 名称 */
	private String name;

	/** 是否内置 */
	private Boolean isSystem;

	/** 描述 */
	private String description;

	/** 权限 */
	private List<String> authorities = new ArrayList<String>();

	/**
	 * 获取名称
	 * 
	 * @return 名称
	 */
	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 * 
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取是否内置
	 * 
	 * @return 是否内置
	 */
	@Column(nullable = false, updatable = false)
	public Boolean getIsSystem() {
		return isSystem;
	}

	/**
	 * 设置是否内置
	 * 
	 * @param isSystem
	 *            是否内置
	 */
	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
	}

	/**
	 * 获取描述
	 * 
	 * @return 描述
	 */
	@Length(max = 200)
	public String getDescription() {
		return description;
	}

	/**
	 * 设置描述
	 * 
	 * @param description
	 *            描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取权限
	 * 
	 * @return 权限
	 */
	@ElementCollection
	@CollectionTable(name = "xx_role_authority")
	public List<String> getAuthorities() {
		return authorities;
	}

	/**
	 * 设置权限
	 * 
	 * @param authorities
	 *            权限
	 */
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
}
