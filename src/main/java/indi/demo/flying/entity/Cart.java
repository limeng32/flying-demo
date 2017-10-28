package indi.demo.flying.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name = "CART")
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键，为UUID形式
	 * 
	 */
	@Id
	@Column(name = "ID")
	private String id;

	/**
	 * 此购物车是否已结帐
	 * 
	 */
	@Column(name = "DEAL")
	private Boolean deal;

	/**
	 * 结账时间
	 * 
	 */
	@Column(name = "DEAL_TIME")
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
