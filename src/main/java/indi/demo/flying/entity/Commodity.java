package indi.demo.flying.entity;

import java.io.Serializable;

import org.apache.ibatis.type.JdbcType;

import indi.mybatis.flying.annotations.FieldMapperAnnotation;
import indi.mybatis.flying.annotations.TableMapperAnnotation;

@TableMapperAnnotation(tableName = "COMMODITY")
public class Commodity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键，以UUID方式保存
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "ID", jdbcType = JdbcType.VARCHAR, isUniqueKey = true)
	private String id;

	/**
	 * 商品名称
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "NAME", jdbcType = JdbcType.VARCHAR)
	private String name;

	/**
	 * 商品价格，以分为单位
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "PRICE", jdbcType = JdbcType.INTEGER)
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
			return "RMB " + price / 100 + " 元 " + price % 100 + " 分";
		} else {
			return null;
		}
	}
}
