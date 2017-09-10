package indi.demo.flying.entity;

import java.io.Serializable;

import org.apache.ibatis.type.JdbcType;

import com.alibaba.fastjson.annotation.JSONField;

import indi.mybatis.flying.annotations.FieldMapperAnnotation;
import indi.mybatis.flying.annotations.TableMapperAnnotation;

@TableMapperAnnotation(tableName = "CART")
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键，以UUID方式保存
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "ID", jdbcType = JdbcType.VARCHAR, isUniqueKey = true)
	private String id;

	/**
	 * 是否成交
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "DEAL", jdbcType = JdbcType.BOOLEAN)
	private Boolean deal;

	/**
	 * 成交时间
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "DEAL_TIME", jdbcType = JdbcType.TIMESTAMP)
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
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
