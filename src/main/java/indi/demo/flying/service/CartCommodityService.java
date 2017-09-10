package indi.demo.flying.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import indi.demo.flying.entity.CartCommodity;
import indi.demo.flying.mapper.CartCommodityMapper;

@Service
public class CartCommodityService implements CartCommodityMapper {

	@Autowired
	private CartCommodityMapper mapper;

	@Override
	public CartCommodity mySelect(Object id) {
		return mapper.mySelect(id);
	}

	@Override
	public Collection<CartCommodity> mySelectAll(CartCommodity t) {
		return mapper.mySelectAll(t);
	}

	@Override
	public CartCommodity mySelectOne(CartCommodity t) {
		return mapper.mySelectOne(t);
	}

	@Override
	public void myInsert(CartCommodity t) {
		mapper.myInsert(t);
	}

	@Override
	public int myUpdate(CartCommodity t) {
		return mapper.myUpdate(t);
	}

	@Override
	public int myUpdatePersistent(CartCommodity t) {
		return mapper.myUpdatePersistent(t);
	}

	@Override
	public int myDelete(CartCommodity t) {
		return mapper.myDelete(t);
	}

	@Override
	public int myCount(CartCommodity t) {
		return mapper.myCount(t);
	}

}
