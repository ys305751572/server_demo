package com.leoman.role.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROLE")
public class Role extends Authority{

	private static final long serialVersionUID = 5330628981781350873L;
	
}
