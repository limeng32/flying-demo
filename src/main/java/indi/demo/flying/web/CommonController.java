package indi.demo.flying.web;

import java.util.Calendar;
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
import indi.demo.flying.entity.CartCommodity;
import indi.demo.flying.entity.Commodity;
import indi.demo.flying.service.CartCommodityService;
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
	private CartCommodityService cartCommodityService;

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

	@RequestMapping(method = { RequestMethod.GET }, value = "/addCommodity")
	public String AddCommodity(HttpServletRequest request, HttpServletResponse response, ModelMap mm,
			@RequestParam(value = "price", required = false) Integer price,
			@RequestParam(value = "name", required = false) String name) {
		Commodity commodity = new Commodity();
		commodity.setName(name);
		commodity.setPrice(price);
		commodityService.myInsert(commodity);
		mm.addAttribute("_content", commodity);
		return UNIQUE_VIEW_NAME;
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/updateCommodity")
	public String updateCommodity(HttpServletRequest request, HttpServletResponse response, ModelMap mm,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "price", required = false) Integer price,
			@RequestParam(value = "name", required = false) String name) {
		Commodity commodity = commodityService.mySelect(id);
		if (commodity != null) {
			if (name != null) {
				commodity.setName(name);
			}
			if (price != null) {
				commodity.setPrice(price);
			}
			commodityService.myUpdate(commodity);
		}
		mm.addAttribute("_content", commodity);
		return UNIQUE_VIEW_NAME;
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/getCommodityByCart")
	public String getCommodityByCart(HttpServletRequest request, HttpServletResponse response, ModelMap mm,
			@RequestParam(value = "id", required = false) String cartId) {
		Cart cartCondition = new Cart();
		cartCondition.setId(cartId);
		CartCommodity cartCommodityCondition = new CartCommodity();
		cartCommodityCondition.setCart(cartCondition);
		Collection<CartCommodity> cartCommodityC = cartCommodityService.mySelectAll(cartCommodityCondition);
		mm.addAttribute("_content", cartCommodityC);
		return UNIQUE_VIEW_NAME;
	}

	/* 对购物车中的商品进行结账 */
	@RequestMapping(method = { RequestMethod.GET }, value = "/dealCart")
	public String dealCart(HttpServletRequest request, HttpServletResponse response, ModelMap mm,
			@RequestParam(value = "id", required = false) String cartId) {
		Cart cart = cartService.mySelect(cartId);
		if (cart != null) {
			cart.setDeal(true);
			cart.setDealTime(Calendar.getInstance().getTime());
			cartService.myUpdate(cart);

			CartCommodity cartCommodityCondition = new CartCommodity();
			cartCommodityCondition.setCart(cart);
			Collection<CartCommodity> cartCommodityC = cartCommodityService.mySelectAll(cartCommodityCondition);
			mm.addAttribute("_content", cartCommodityC);
		}
		return UNIQUE_VIEW_NAME;
	}

	/* 将购物车中的商品恢复成未结账状态 */
	@RequestMapping(method = { RequestMethod.GET }, value = "/unDealCart")
	public String unDealCart(HttpServletRequest request, HttpServletResponse response, ModelMap mm,
			@RequestParam(value = "id", required = false) String cartId) {
		Cart cart = cartService.mySelect(cartId);
		if (cart != null) {
			cart.setDeal(false);
			cart.setDealTime(null);
			cartService.myUpdatePersistent(cart);

			CartCommodity cartCommodityCondition = new CartCommodity();
			cartCommodityCondition.setCart(cart);
			Collection<CartCommodity> cartCommodityC = cartCommodityService.mySelectAll(cartCommodityCondition);
			mm.addAttribute("_content", cartCommodityC);
		}
		return UNIQUE_VIEW_NAME;
	}
}
