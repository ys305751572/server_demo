package com.leoman.log.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.leoman.baisc.entity.BaseEntity;

/**
 * 日志实例
 * @author yesong
 *
 */
@Table(name="t_log")
@Entity
public class Log extends BaseEntity{
	
	private static final long serialVersionUID = -8355395329391698778L;

	/** "日志内容"属性名称 */
	public static final String LOG_CONTENT_ATTRIBUTE_NAME = Log.class.getName() + ".CONTENT";
	
	// 操作
	private String operation;
	
	// 操作员
	private String operator;
	
	// 内容
	private String content;
	
	// 请求参数
	private String parameter;
	
	// IP
	private String ip;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
