package indi.demo.flying.entity;

import java.io.Serializable;

import org.apache.ibatis.type.JdbcType;

import indi.mybatis.flying.annotations.FieldMapperAnnotation;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ��������UUID��ʽ����
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "ID", jdbcType = JdbcType.VARCHAR, isUniqueKey = true)
	private String id;

	/**
	 * �Ƿ�ɽ�
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "DEAL", jdbcType = JdbcType.BOOLEAN)
	private Boolean deal;

	/**
	 * �ɽ�ʱ��
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "DEAL_TIME", jdbcType = JdbcType.TIMESTAMP)
	private java.util.Date dealTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getDeal() {
		return deal;
	}

	public void setDeal(Boolean deal) {
		this.deal = deal;
	}

	public java.util.Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(java.util.Date dealTime) {
		this.dealTime = dealTime;
	}

}
