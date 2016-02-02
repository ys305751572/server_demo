package com.leoman.module.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.leoman.baisc.entity.BaseEntity;

@Entity
@Table(name="t_module")
public class Module extends BaseEntity{

	private static final long serialVersionUID = 986592508272421306L;

	private String moduleName;
	
	private String url;
	
	private String desc;

	@Column(name="module_name")
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Column(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name="desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
