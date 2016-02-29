package com.leoman.auth.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MENU_RESOURCE")
public class MenuResource extends Resource{

	private static final long serialVersionUID = -6962155274187233564L;

}
