# mybatis.flying 自动映射 pojo 的 demo

How to play？

1、获取代码（clone or fork），搭建成 maven 项目。

2、以 maven 命令执行 tomcat7:run

3、以下是初始化时的添加的默认数据，它描述了两个购物车、12种商品和商品装入购物车的情况：

<dataset>
	<CART ID="1" DEAL="0" DEAL_TIME=null />
	<CART ID="2" DEAL="0" DEAL_TIME=null />
	<COMMODITY ID="1" NAME="牙刷A" PRICE="1200" />
	<COMMODITY ID="2" NAME="牙刷B" PRICE="1850" />
	<COMMODITY ID="3" NAME="牙刷C" PRICE="2100" />
	<COMMODITY ID="4" NAME="佳洁士牙膏" PRICE="1499" />
	<COMMODITY ID="5" NAME="六必治牙膏" PRICE="1999" />
	<COMMODITY ID="6" NAME="云南白药牙膏" PRICE="2499" />
	<COMMODITY ID="7" NAME="牙刷A" PRICE="3500" />
	<COMMODITY ID="8" NAME="牙刷B" PRICE="3900" />
	<COMMODITY ID="9" NAME="牙刷C" PRICE="5100" />
	<COMMODITY ID="10" NAME="佳洁士牙膏" PRICE="2800" />
	<COMMODITY ID="11" NAME="六必治牙膏" PRICE="3200" />
	<COMMODITY ID="12" NAME="云南白药牙膏" PRICE="4900" />
	<CART_COMMODITY ID="1" CART_ID="1" COMM_ID="1" AMOUNT="3" />
	<CART_COMMODITY ID="2" CART_ID="1" COMM_ID="5" AMOUNT="4" />
	<CART_COMMODITY ID="3" CART_ID="1" COMM_ID="8" AMOUNT="1" />
	<CART_COMMODITY ID="4" CART_ID="1" COMM_ID="12" AMOUNT="1" />
	<CART_COMMODITY ID="5" CART_ID="2" COMM_ID="2" AMOUNT="2" />
	<CART_COMMODITY ID="6" CART_ID="2" COMM_ID="4" AMOUNT="1" />
	<CART_COMMODITY ID="7" CART_ID="2" COMM_ID="9" AMOUNT="2" />
	<CART_COMMODITY ID="8" CART_ID="2" COMM_ID="11" AMOUNT="1" />
</dataset>

现在，在浏览器中输入以下 url 可以看到效果：

查看购物车：			http://localhost:8080/flying-demo/getCart?id=${购物车cart的id}

查看商品：			http://localhost:8080/flying-demo/getCommodity?id=${商品commodity的id}

翻页查看商品：		http://localhost:8080/flying-demo/getCommodityInPage?pageNum=${页码}&priceOrder=${按价格升序或降序输入asc或desc}&priceFrom=${价格最小值}&priceTo=${价格最大值}

增加新商品：			http://localhost:8080/flying-demo/addCommodity?name=${新商品名称}&price=${新商品价格}

编辑商品：			http://localhost:8080/flying-demo/updateCommodity?id=${商品的id}&name=${商品的名称}&price=${商品的价格}

查看购物车中的商品：	http://localhost:8080/flying-demo/getCommodityByCart?id=${购物车的id}

对购物车进行结账：	http://localhost:8080/flying-demo/dealCart?id=${购物车的id}

取消购物车的结账：	http://localhost:8080/flying-demo/undealCart?id=${购物车的id}

以上方法的实现可参见 https://github.com/limeng32/flying-demo/blob/master/src/main/java/indi/demo/flying/web/CommonController.java ，如果 pojo 采用双向相关的方式构建可以写出更灵活强大的交互功能，不过这已超过本例的讨论范围。
