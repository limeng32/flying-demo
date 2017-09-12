package indi.demo.flying.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import indi.demo.flying.condition.CommodityCondition;
import indi.demo.flying.entity.Cart;
import indi.demo.flying.entity.Commodity;
import indi.demo.flying.service.CartService;
import indi.demo.flying.service.CommodityService;
import indi.mybatis.flying.models.Conditionable;
import indi.mybatis.flying.pagination.Order;
import indi.mybatis.flying.pagination.Page;
import indi.mybatis.flying.pagination.PageParam;
import indi.mybatis.flying.pagination.SortParam;

@Controller
public class CommonController {

	public static final String UNIQUE_VIEW_NAME = "__unique_view_name";

	@Autowired
	private CartService cartService;

	@Autowired
	private CommodityService commodityService;

	@RequestMapping(method = { RequestMethod.GET }, value = "/getCart")
	public String getCart(HttpServletRequest request, HttpServletResponse response, ModelMap mm,
			@RequestParam("id") String id) {
		Cart cart = cartService.mySelect(id);
		mm.addAttribute("_content", cart);
		return UNIQUE_VIEW_NAME;
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/getCommodity")
	public String getCommodity(HttpServletRequest request, HttpServletResponse response, ModelMap mm,
			@RequestParam("id") String id) {
		Commodity commodity = commodityService.mySelect(id);
		mm.addAttribute("_content", commodity);
		return UNIQUE_VIEW_NAME;
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/getCommodityInPage")
	public String getCommodityInPage(HttpServletRequest request, HttpServletResponse response, ModelMap mm,
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "priceOrder", required = false) String priceOrder,
			@RequestParam(value = "priceFrom", required = false) Integer priceFrom,
			@RequestParam(value = "priceTo", required = false) Integer priceTo) {
		CommodityCondition commodityCondition = new CommodityCondition();
		if (priceFrom != null) {
			commodityCondition.setPriceFrom(priceFrom);
		}
		if (priceTo != null) {
			commodityCondition.setPriceTo(priceTo);
		}
		Conditionable.Sequence sequence = null;
		try {
			sequence = Conditionable.Sequence.valueOf(priceOrder);
		} catch (Exception e) {
		}
		if (sequence != null) {
			commodityCondition.setSorter(new SortParam(new Order("PRICE", sequence)));
		}
		if (pageNum != null && pageNum >= 0) {
			commodityCondition.setLimiter(new PageParam(pageNum, 10));
		}
		Collection<Commodity> commodityC = commodityService.mySelectAll(commodityCondition);
		if (commodityCondition.getLimiter() == null) {
			mm.addAttribute("_content", commodityC);
		} else {
			Page<Commodity> page = new Page<>(commodityC, commodityCondition.getLimiter());
			mm.addAttribute("_content", page);
		}
		return UNIQUE_VIEW_NAME;
	}
}
