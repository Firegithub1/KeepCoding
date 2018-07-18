# 20180410

# Web项目：查询Mysql 展示所有商品

<a href="https://github.com/renkaigis/KeepCoding/tree/master/2018/04/10" target="_blank">参见程序源代码</a>

## 需求:

	点击首页上的超链接,在页面上展示所有的商品信息
	
## 步骤分析:

### 1.数据库和表
	
```sql
create database test0410;
use test0410;
create table `product` (
    `pid` varchar (96),
    `pname` varchar (150),
    `market_price` double ,
    `shop_price` double ,
    `pimage` varchar (600),
    `pdate` date ,
    `pdesc` varchar (765)
); 

INSERT INTO `product` VALUES('1','小米 4c 标准版','1399','1299','products/1/c_0001.jpg','2015-11-02','小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待');
INSERT INTO `product` VALUES('10','华为 Ascend Mate7','2699','2599','products/1/c_0010.jpg','2015-11-02','华为 Ascend Mate7 月光银 移动4G手机 双卡双待双通6英寸高清大屏，纤薄机身，智能超八核，按压式指纹识别！!选择下方“移动老用户4G飞享合约”，无需换号，还有话费每月返还！');
INSERT INTO `product`  VALUES('11','vivo X5Pro','2399','2298','products/1/c_0014.jpg','2015-11-02','移动联通双4G手机 3G运存版 极光白【购机送蓝牙耳机+蓝牙自拍杆】新升级3G运行内存·双2.5D弧面玻璃·眼球识别技术');
INSERT INTO `product`  VALUES('12','努比亚（nubia）My 布拉格','1899','1799','products/1/c_0013.jpg','2015-11-02','努比亚（nubia）My 布拉格 银白 移动联通4G手机 双卡双待【嗨11，下单立减100】金属机身，快速充电！布拉格相机全新体验！');
INSERT INTO `product`  VALUES('13','华为 麦芒4','2599','2499','products/1/c_0012.jpg','2015-11-02','华为 麦芒4 晨曦金 全网通版4G手机 双卡双待金属机身 2.5D弧面屏 指纹解锁 光学防抖');
INSERT INTO `product`  VALUES('14','vivo X5M','1899','1799','products/1/c_0011.jpg','2015-11-02','vivo X5M 移动4G手机 双卡双待 香槟金【购机送蓝牙耳机+蓝牙自拍杆】5.0英寸大屏显示·八核双卡双待·Hi-Fi移动KTV');
INSERT INTO `product`  VALUES('15','Apple iPhone 6 (A1586)','4399','4288','products/1/c_0015.jpg','2015-11-02','Apple iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机长期省才是真的省！点击购机送费版，月月送话费，月月享优惠，畅享4G网络，就在联通4G！');
```

### 2.新建一个项目

<img src="http://image.renkaigis.com/keepcoding/2018041001.png">

### 3.导入jar包

驱动 dbutils c3p0 jstl beanutils

### 4.包结构

utils工具类:data sourceutils

导入c3p0配置文件

```xml
<c3p0-config>
	<!-- 默认配置，如果没有指定则使用这个配置 -->
	<default-config>
		<!-- 基本配置 -->
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/test0410</property>
		<property name="user">root</property>
		<property name="password">541638</property>
	
		<!--扩展配置-->
		<property name="checkoutTimeout">30000</property>
		<property name="idleConnectionTestPeriod">30</property>
		<property name="initialPoolSize">10</property>
		<property name="maxIdleTime">30</property>
		<property name="maxPoolSize">100</property>
		<property name="minPoolSize">10</property>
		<property name="maxStatements">200</property>
	</default-config> 
</c3p0-config>
```

### 5.新建一个首页index.jsp

添加一个超链接

```html
<h2><a href="${pageContext.request.contextPath}/findAll">展示所有商品</a></h2>
```

### 6.点击超链接 发送一个servlet上(FindAllServlet)

见上步

### 7.FindAllServlet:

调用service，查询所有的商品 返回值:list

将list放入request域中,请求转发 prodouct_list.jsp

**FinaAllServlet:**

```java
List<Product> pList=null;
try {
    pList = new ProductService().FindAll();
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

request.setAttribute("list", pList);

request.getRequestDispatcher("/product_list.jsp").forward(request, response);
```

**ProductService:**

```java
public List<Product> FindAll() throws SQLException {
    // TODO Auto-generated method stub
    return new ProductDao().FindAll();
}
```

**ProductDao:**

```java
public List<Product> FindAll() throws SQLException {
    // TODO Auto-generated method stub
    QueryRunner qRunner=new QueryRunner(DataSourceUtils.getDataSource());
    
    String sql="select * from product";
    
    return qRunner.query(sql, new BeanListHandler<>(Product.class));
}
```

**Product:**

```java
public class Product {
	/*
	 * 	
	`pid` varchar (96),
	`pname` varchar (150),
	`market_price` double ,
	`shop_price` double ,
	`pimage` varchar (600),
	`pdate` date ,
	`pdesc` varchar (765)
	 */
	
	private String pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String pimage;
	private Date pdate;
	private String pdesc;
	
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
}
```

**product_list.jsp**

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1"  align="center" width="88%">
		<tr>
			<th>ID</th>
			<th>图片</th>
			<th>商品名</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>描述</th>
		</tr>
		<c:forEach items="${list }" var="p">
			<tr>
				<td width="2%">${p.pid}</td>
				<td width="8%"><img src="${pageContext.request.contextPath}/${p.pimage}" width="80"></td>
				<td width="8%">${p.pname}</td>
				<td width="8%">${p.market_price}</td>
				<td width="8%">${p.shop_price}</td>
				<td>${p.pdesc}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
```

需要用到 `tomcat` 部署，然后打开链接：http://localhost:8080/test0410

**运行结果：**

<img src="http://image.renkaigis.com/keepcoding/2018041002.png">

<img src="http://image.renkaigis.com/keepcoding/2018041003.png">
