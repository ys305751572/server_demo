package com.leoman.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.leoman.baisc.entity.BaseEntity;

public class EntityListener {

	@PrePersist
	public void prePersist(BaseEntity entity) {
		entity.setCreateDate(new Date());
	}
	
	@PreUpdate
	public void preUpdate(BaseEntity entity) {
		entity.setUpdateDate(new Date());
	}
}
