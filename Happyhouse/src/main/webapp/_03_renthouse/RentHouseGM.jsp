<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>好宅網-首頁</title>
<meta name="description" content="free website template" />
<meta name="keywords" content="enter your keywords here" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="/Happyhouse/css/style.css" />
<script type="text/javascript" src="/Happyhouse/js/jquery.min.js"></script>
<script type="text/javascript" src="/Happyhouse/js/jquery.easing.min.js"></script>
<script type="text/javascript" src="/Happyhouse/js/jquery.nivo.slider.pack.js"></script>


<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 

<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});
	function toggle(source) {
		  checkboxes = document.getElementsByName('delete_renthouse_id');
		  for(var i=0, n=checkboxes.length;i<n;i++) {
		    checkboxes[i].checked = source.checked;
		  }
		}
	
	$(function() {
	    $( "#dialog" ).dialog({
	      autoOpen: false,
	      show: {
	        effect: "blind",
	        duration: 1000
	      },
	      hide: {
	        effect: "explode",
	        duration: 1000
	      }
	    });
	 
	    $( "#opener" ).click(function() {
	      $( "#dialog" ).dialog( "open" );
	    });
	  });
	
	
</script>
</head>
<body>
		<div id="main">
		<div id="site_content">
			<div id="site_heading">
				<h1>好宅房屋網</h1>
				<h2>你刊登房屋的超棒選擇</h2>
			</div>
			<!--close site_heading-->
			<div id="header">
				<div id="menubar">
					<ul id="menu">
						<li class="current"><a href="/Happyhouse/index.jsp">首頁</a></li>
						<li><a href="/Happyhouse/_02_renthouse/rentHouseSearch.jsp">出售專區</a>
						<ul>
						<li><a href="#">搜尋出售</a></li>
                        <li><a href="#">刊登出售</a></li>
                        <li><a href="#">查詢出售收藏</a></li>
						</ul>
						</li>
						<li><a href="testimonials.html">刊登出租</a>
						<ul>
						<li><a href="#">搜尋出租</a></li>
                        <li><a href="#">刊登出租</a></li>
                        <li><a href="#">查詢出租收藏</a></li>
						</ul>
						</li>
						<li><a href="/Happyhouse/_09_furniture/product.jsp">二手家具</a>	
						<ul>
						<li><a href="/Happyhouse/_09_furniture/product.jsp">搜尋家具</a></li>	
						<li><a href="/Happyhouse/_09_furniture/product.jsp">刊登二手家具</a></li>	
						</ul>
						</li>
						<li><a href="/Happyhouse/addarticle.controller">討論區</a></li>										
						<c:if test="${empty LoginOK}">
						<li><a href="/Happyhouse/_01_users/login.jsp">會員登入</a></li>
						</c:if>
						<c:if test="${not empty LoginOK}">
						<li><a href="/Happyhouse/_08_news/Gmindex.jsp">管理者頁面</a></li>
						<li><a href="">個人管理頁面</a>
						<ul>
						<li><a href="/Happyhouse/sms.controller">修改個人密碼</a></li>
						<li><a href="/Happyhouse/sms.controller">個人站內信箱</a></li>
						<li></li>
						</ul>
						</li>
						<li><a href="/Happyhouse/_01_users/logout.jsp">登出</a></li>
						</c:if>
					</ul>
				</div>
				<!--close menubar-->
			</div>
			<c:if test="${not empty LoginOK}">
			<h1 align="center"><font color=blue>${LoginOK.user_name}你好</font></h1>
			</c:if>
			<!--close header-->
			<div style="padding-left:150px">
		<form  action="<c:url value="/renthouse.GM.controller"/>"method="post" >
<table>
<tr>
<td><input type="hidden" name="renthouse_id" value="${param.renthouse_id}" ></td>
</tr>
<tr>
<td><input type="hidden" name="user_account" value="${param.user_account}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_name" value="${param.renthouse_name}" ></td>
</tr>
<td><input type="hidden" name="renthouse_price" value="${param.renthouse_price}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_patterns" value="${param.renthouse_patterns}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_describe" value="${param.renthouse_describe}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_size" value="${param.renthouse_size}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_floor" value="${param.renthouse_floor}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_rentdate" value="${param.renthouse_rentdate}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_type" value="${param.renthouse_type}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_message" value="${param.renthouse_message}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_date" value="${param.renthouse_date}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_car" value="${param.renthouse_car}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_phone" value="${param.renthouse_phone}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_email" value="${param.renthouse_email}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_reportfrom" value="${param.renthouse_reportfrom}" ></td>
</tr>
<tr>
<td><input type="hidden" name="renthouse_reportreason" value="${param.renthouse_reportreason}" ></td>
</tr>
</table>
<table>                                                                 

<c:if test="${not empty RentGMselect}">
		<table border=1 cellpadding=20 >
<!-- 			<thead> -->
<!-- 				<th>標題</th> -->
<!-- 				<th>價格</th> -->
<!-- 				<th>格局</th> -->
<!-- 				<th>地址</th> -->
<!-- 				<th>描述</th> -->
<!-- 				<th>坪數</th> -->
<!-- 				<th>樓層</th> -->
<!-- 				<th>屋齡</th> -->
<!-- 				<th>刊登日期</th> -->
<!-- 				<th>車位</th> -->

<!-- 			</thead> -->
<tr><td>遭檢舉</td></tr>
			<tbody>
				<c:forEach var="row" items="${RentGMselect}">
					<c:url value="/_03_renthouse/RentHouseSingleView.jsp" var="path" scope="page">
						<c:param name="user_account" value="${row.user_account}" />
						<c:param name="renthouse_id" value="${row.renthouse_id}" />
						<c:param name="renthouse_name" value="${row.renthouse_name}" />
						<c:param name="renthouse_price" value="${row.renthouse_price}" />
						<c:param name="renthouse_patterns" value="${row.renthouse_patterns}" />
						<c:param name="renthouse_address" value="${row.renthouse_address}" />
						<c:param name="renthouse_deposit" value="${row.renthouse_deposit}" />
						<c:param name="renthouse_describe" value="${row.renthouse_describe}" />
						<c:param name="renthouse_size" value="${row.renthouse_size}" />
						<c:param name="renthouse_floor" value="${row.renthouse_floor}" />
						<c:param name="renthouse_rentdate" value="${row.renthouse_rentdate}" />
						<c:param name="renthouse_message" value="${row.renthouse_message}" />
						<c:param name="renthouse_date" value="${row.renthouse_date}" />
						<c:param name="renthouse_car" value="${row.renthouse_car}" />
						<c:param name="renthouse_phone" value="${row.renthouse_phone}" />
						<c:param name="renthouse_email" value="${row.renthouse_email}" />
						<c:param name="renthouse_reportfrom" value="${row.renthouse_reportfrom}" />
						<c:param name="renthouse_reportreason" value="${row.renthouse_reportreason}" />			
					</c:url>					
					<tr>
						<c:if test="${row.renthouse_type=='B'}">
					<td colspan=2> <img  src="${pageContext.servletContext.contextPath}/rentimage1?renthouse_id=${row.renthouse_id}" width="75px"></td>
						<td><h3 style="color:RED";font-style: italic"><a href="${path}">${row.renthouse_name}</a></h3>
						<input type="hidden" name="id" value="${row.renthouse_id}">
						<h3>${row.renthouse_address}</h5>
						<h3>${row.renthouse_patterns}</h3>
						</td>
						<td>${row.renthouse_price}</td>
						<td>${row.renthouse_size}</td>
						<td>${row.renthouse_date}</td>
						<td>${row.renthouse_type}</td>	
						<td><button id="opener" type="button">Open Dialog</button></td>
						<td><select name="type" value="狀態">
						<option value="A">回復正常</option>
						
						<option value="C">封鎖</option>
						</select>
					<input type="submit" value="修改" name="prodaction"/></td>
					</c:if>
					</tr>
				</c:forEach>
			</tbody>
			<tr><td>以封鎖</td></tr>
			<tbody>
				<c:forEach var="row" items="${RentGMselect}">
					<c:url value="/_03_renthouse/RentHouseSingleView.jsp" var="path" scope="page">
						<c:param name="user_account" value="${row.user_account}" />
						<c:param name="renthouse_id" value="${row.renthouse_id}" />
						<c:param name="renthouse_name" value="${row.renthouse_name}" />
						<c:param name="renthouse_price" value="${row.renthouse_price}" />
						<c:param name="renthouse_patterns" value="${row.renthouse_patterns}" />
						<c:param name="renthouse_address" value="${row.renthouse_address}" />
						<c:param name="renthouse_deposit" value="${row.renthouse_deposit}" />
						<c:param name="renthouse_describe" value="${row.renthouse_describe}" />
						<c:param name="renthouse_size" value="${row.renthouse_size}" />
						<c:param name="renthouse_floor" value="${row.renthouse_floor}" />
						<c:param name="renthouse_rentdate" value="${row.renthouse_rentdate}" />
						<c:param name="renthouse_message" value="${row.renthouse_message}" />
						<c:param name="renthouse_date" value="${row.renthouse_date}" />
						<c:param name="renthouse_car" value="${row.renthouse_car}" />
						<c:param name="renthouse_phone" value="${row.renthouse_phone}" />
						<c:param name="renthouse_email" value="${row.renthouse_email}" />
						<c:param name="renthouse_reportfrom" value="${row.renthouse_reportfrom}" />
						<c:param name="renthouse_reportreason" value="${row.renthouse_reportreason}" />			
					</c:url>		
					<tr>
					<c:if test="${row.renthouse_type=='C'}">
					<td colspan=2> <img  src="${pageContext.servletContext.contextPath}/rentimage1?renthouse_id=${row.renthouse_id}" width="75px"></td>
						<td><h3 style="color:RED";font-style: italic"><a href="${path}">${row.renthouse_name}</a></h3>
						<input type="hidden" name="id" value="${row.renthouse_id}">
						<h3>${row.renthouse_address}</h5>
						<h3>${row.renthouse_patterns}</h3>
						</td>
						<td>${row.renthouse_price}</td>
						<td>${row.renthouse_size}</td>
						<td>${row.renthouse_date}</td>
						<td>${row.renthouse_type}</td>
						
						<td><select name="type" value="狀態">
						<option value="A">回復正常</option>
						<option value="B">解除封鎖</option>
						
						</select>
					<input type="submit" value="修改" name="prodaction"/></td>
					</c:if>
					</tr>
					
				</c:forEach>
			
			</tbody>
			
			
			
		</table>
	</c:if>
	</div>
		</form>		
		<!--close site_content-->
			<div id="footer">
			<a href="http://validator.w3.org/check?uri=referer">好宅網，最專業、最豐富的新屋、預售屋展示平台 |</a>
			<a href="http://validator.w3.org/check?uri=referer">好宅網有限公司 版權所有 © 2015-2016 HappyHouse. All Rights Reserved. </a>
		</div>
		<!--close footer-->
		<div id="dialog" title="檢舉原因">
 		<p>檢舉人:${row.renthouse_reportfrom}</p>
		</div>	
		
</body>
</html>