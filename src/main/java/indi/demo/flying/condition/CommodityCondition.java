package indi.demo.flying.condition;

import indi.demo.flying.entity.Commodity;
import indi.mybatis.flying.annotations.ConditionMapperAnnotation;
import indi.mybatis.flying.models.Conditionable;
import indi.mybatis.flying.models.Limitable;
import indi.mybatis.flying.models.Sortable;
import indi.mybatis.flying.statics.ConditionType;

public class CommodityCondition extends Commodity implements Conditionable {

	private static final long serialVersionUID = 1L;

	private Limitable limiter;

	private Sortable sorter;

	@ConditionMapperAnnotation(dbFieldName = "PRICE", conditionType = ConditionType.GreaterOrEqual)
	private Integer priceFrom;

	@ConditionMapperAnnotation(dbFieldName = "PRICE", conditionType = ConditionType.LessOrEqual)
	private Integer priceTo;

	@Override
	public Limitable getLimiter() {
		return limiter;
	}

	@Override
	public void setLimiter(Limitable limiter) {
		this.limiter = limiter;
	}

	@Override
	public Sortable getSorter() {
		return sorter;
	}

	@Override
	public void setSorter(Sortable sorter) {
		this.sorter = sorter;
	}

	public Integer getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(Integer priceFrom) {
		this.priceFrom = priceFrom;
	}

	public Integer getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(Integer priceTo) {
		this.priceTo = priceTo;
	}

}
