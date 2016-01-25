package com.leoman.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoman.baisc.service.impl.BaseServiceImpl;
import com.leoman.log.dao.LogDao;
import com.leoman.log.entity.Log;
import com.leoman.log.service.LogService;

@Service(value="logServiceImpl")
public class LogServiceImpl extends BaseServiceImpl<Log, Long> implements LogService {

	@SuppressWarnings("unused")
	@Autowired
	private LogDao logDao;

	@Autowired
	public void setLogDao(LogDao logDao) {
		super.setBaseDao(logDao);
	}
}
