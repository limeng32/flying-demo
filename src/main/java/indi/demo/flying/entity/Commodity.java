package indi.demo.flying.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "COMMODITY")
public class Commodity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键，为UUID形式
	 * 
	 */
	@Id
	@Column(name = "ID")
	private String id;

	/**
	 * 商品名称
	 * 
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 商品价格，以分为单位
	 * 
	 */
	@Column(name = "PRICE")
	private Integer price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPriceStr() {
		if (price != null) {
			return "RMB " + price / 100 + "." + price % 100 + " YUAN";
		} else {
			return null;
		}
	}
}
