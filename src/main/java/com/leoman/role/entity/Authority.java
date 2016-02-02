package com.leoman.role.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import com.leoman.baisc.entity.BaseEntity;

@Table(name = "t_authorities")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CATEGORY",discriminatorType = DiscriminatorType.STRING)
public abstract class Authority extends BaseEntity{

	private static final long serialVersionUID = 386283919735548978L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
