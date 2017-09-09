package indi.demo.flying.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import indi.demo.flying.entity.Commodity;
import indi.demo.flying.mapper.CommodityMapper;

@Service
public class CommodityService implements CommodityMapper {

	@Autowired
	private CommodityMapper mapper;

	@Override
	public Commodity mySelect(Object id) {
		return mapper.mySelect(id);
	}

	@Override
	public Collection<Commodity> mySelectAll(Commodity t) {
		return mapper.mySelectAll(t);
	}

	@Override
	public Commodity mySelectOne(Commodity t) {
		return mapper.mySelectOne(t);
	}

	@Override
	public void myInsert(Commodity t) {
		mapper.myInsert(t);
	}

	@Override
	public int myUpdate(Commodity t) {
		return mapper.myUpdate(t);
	}

	@Override
	public int myUpdatePersistent(Commodity t) {
		return mapper.myUpdatePersistent(t);
	}

	@Override
	public int myDelete(Commodity t) {
		return mapper.myDelete(t);
	}

	@Override
	public int myCount(Commodity t) {
		return mapper.myCount(t);
	}

}
