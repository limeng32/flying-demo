package indi.demo.flying.mapper;

import java.util.Collection;

import indi.demo.flying.entity.CartCommodity;

public interface CartCommodityMapper {

	public CartCommodity mySelect(Object id);

	public Collection<CartCommodity> mySelectAll(CartCommodity t);

	public CartCommodity mySelectOne(CartCommodity t);

	public void myInsert(CartCommodity t);

	public int myUpdate(CartCommodity t);

	public int myUpdatePersistent(CartCommodity t);

	public int myDelete(CartCommodity t);

	public int myCount(CartCommodity t);
}
