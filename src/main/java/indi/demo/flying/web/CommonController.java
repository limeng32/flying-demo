package indi.demo.flying.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import indi.demo.flying.entity.Cart;
import indi.demo.flying.entity.Commodity;
import indi.demo.flying.service.CartService;
import indi.demo.flying.service.CommodityService;

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
}
