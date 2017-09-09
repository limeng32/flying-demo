package indi.demo.flying.mapper;

import java.util.Collection;

import indi.demo.flying.entity.Commodity;

public interface CommodityMapper {

	public Commodity mySelect(Object id);

	public Collection<Commodity> mySelectAll(Commodity t);

	public Commodity mySelectOne(Commodity t);

	public void myInsert(Commodity t);

	public int myUpdate(Commodity t);

	public int myUpdatePersistent(Commodity t);

	public int myDelete(Commodity t);

	public int myCount(Commodity t);
}
