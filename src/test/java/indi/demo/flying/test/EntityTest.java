package indi.demo.flying.test;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.github.springtestdbunit.dataset.FlatXmlDataSetLoader;

import indi.demo.flying.entity.Cart;
import indi.demo.flying.entity.CartCommodity;
import indi.demo.flying.entity.Commodity;
import indi.demo.flying.service.CartCommodityService;
import indi.demo.flying.service.CartService;
import indi.demo.flying.service.CommodityService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader = FlatXmlDataSetLoader.class, databaseConnection = { "dataSource" })
@ContextConfiguration("classpath:spring-test.xml")
public class EntityTest {

	@Autowired
	private CartService cartService;

	@Autowired
	private CartCommodityService cartCommodityService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private DataSource dataSource;

	@Test
	public void testDataSource() {
		Assert.assertNotNull(dataSource);
	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/indi/demo/flying/test/entityTest/testCart.xml")
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/indi/demo/flying/test/entityTest/testCart.result.xml")
	@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = "/indi/demo/flying/test/entityTest/testCart.result.xml")
	public void testCart() {
		Cart cart = cartService.mySelect("aaa");
		Assert.assertFalse(cart.getDeal());
		cart.setDeal(true);
		cartService.myUpdate(cart);

		Cart cart2 = cartService.mySelect("bbb");
		Assert.assertTrue(cart2.getDeal());
		cartService.myDelete(cart2);
	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/indi/demo/flying/test/entityTest/testCommodity.xml")
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/indi/demo/flying/test/entityTest/testCommodity.result.xml")
	@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = "/indi/demo/flying/test/entityTest/testCommodity.result.xml")
	public void testCommodity() {
		Commodity commodity = commodityService.mySelect("mmm");
		Assert.assertEquals("—¿À¢", commodity.getName());
		commodity.setPrice(1500);
		commodityService.myUpdate(commodity);

		Commodity commodity2 = commodityService.mySelect("nnn");
		Assert.assertEquals(2000, commodity2.getPrice().intValue());
		commodityService.myDelete(commodity2);
	}

	@Test
	@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/indi/demo/flying/test/entityTest/testCartCommodity.xml")
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/indi/demo/flying/test/entityTest/testCartCommodity.result.xml")
	@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = "/indi/demo/flying/test/entityTest/testCartCommodity.result.xml")
	public void testCartCommodity() {
		CartCommodity cartCommodity = cartCommodityService.mySelect("w");
		Assert.assertEquals("—¿À¢", cartCommodity.getCommodity().getName());

		Commodity comm2 = commodityService.mySelect("ooo");
		cartCommodity.setCommodity(comm2);
		cartCommodityService.myUpdate(cartCommodity);
	}
}
