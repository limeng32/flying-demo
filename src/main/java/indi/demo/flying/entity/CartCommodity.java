package indi.demo.flying.entity;

import java.io.Serializable;

import org.apache.ibatis.type.JdbcType;

import indi.mybatis.flying.annotations.FieldMapperAnnotation;

public class CartCommodity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 关联的购物车
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "CART_ID", jdbcType = JdbcType.VARCHAR, dbAssociationUniqueKey = "ID")
	private Cart cart;

	/**
	 * 关联的商品
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "COMM_ID", jdbcType = JdbcType.VARCHAR, dbAssociationUniqueKey = "ID")
	private Commodity commodity;

	/**
	 * 此种商品的数量
	 * 
	 */
	@FieldMapperAnnotation(dbFieldName = "AMOUNT", jdbcType = JdbcType.INTEGER)
	private Integer amount;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
