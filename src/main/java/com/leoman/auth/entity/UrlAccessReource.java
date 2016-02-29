package com.leoman.auth.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "URL_ACCESS_RESOURCE")
public class UrlAccessReource extends Resource{

	private static final long serialVersionUID = 7101254372725365425L;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
