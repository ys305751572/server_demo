package com.leoman.auth.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.leoman.baisc.entity.BaseEntity;

@Entity
@Table(name = "tb_resource")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CATEGORY",discriminatorType = DiscriminatorType.STRING)
public class Resource extends BaseEntity{

	private static final long serialVersionUID = 3441121422630660776L;

}
