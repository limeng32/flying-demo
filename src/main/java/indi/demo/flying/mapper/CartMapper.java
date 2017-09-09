package indi.demo.flying.mapper;

import java.util.Collection;

import indi.demo.flying.entity.Cart;

public interface CartMapper {

	public Cart mySelect(Object id);

	public Collection<Cart> mySelectAll(Cart t);

	public Cart mySelectOne(Cart t);

	public void myInsert(Cart t);

	public int myUpdate(Cart t);

	public int myUpdatePersistent(Cart t);

	public int myDelete(Cart t);

	public int myCount(Cart t);
}
