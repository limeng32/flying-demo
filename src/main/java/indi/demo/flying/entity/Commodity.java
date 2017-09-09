package indi.demo.flying.entity;

import java.io.Serializable;

import org.apache.ibatis.type.JdbcType;

import indi.mybatis.flying.annotations.FieldMapperAnnotation;

public class Commodity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ��������UUID��ʽ����
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "ID", jdbcType = JdbcType.VARCHAR, isUniqueKey = true)
	private String id;

	/**
	 * ��Ʒ����
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "NAME", jdbcType = JdbcType.VARCHAR)
	private String name;

	/**
	 * ��Ʒ�۸��Է�Ϊ��λ
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

}