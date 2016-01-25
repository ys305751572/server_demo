package com.leoman.log.dao.impl;

import org.springframework.stereotype.Repository;
import com.leoman.baisc.dao.impl.BaseDaoImpl;
import com.leoman.log.dao.LogDao;
import com.leoman.log.entity.Log;

@Repository
public class LogDaoImpl extends BaseDaoImpl<Log, Long> implements LogDao{

}
