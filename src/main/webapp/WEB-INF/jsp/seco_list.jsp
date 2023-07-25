<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, model.UserInfoBean" %>
<%
String userName = (String) request.getAttribute("userName");
String itemCategory = (String) request.getAttribute("itemCategory");
String area = (String) request.getAttribute("area");
if(area == "") {
	area = "全地域";
}

if(itemCategory == "") {
	itemCategory = "全カテゴリ";
	}

if (userName == "") {
	userName = "指定なし";
}

%>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content= "width=device-width, initial-scale=1">
		<title>SECO  | ～Joy share～</title>
		<link rel="stylesheet" href="css/seco_style.css">
		<link href="https://fonts.googleapis.com/css?family=Cherry+Swash:700" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Homemade+Apple" rel="stylesheet">	
	</head>
	
	<body id="top">
	
	
		<!-- ヘッダー -->
		
		<header class="header">
			<div class="logo">
				<a href="Index">
				<h2>SECO <span class="joy">- Joy share -</span></h2>
				</a>
			</div>
		</header>

		<!-- ヘッダーここまで -->

		<!--	
		<h1 class="hero menu">メニュー</h1>
		-->

		<main>
			<h3>検索結果 地域：<%=area%> | カテゴリ：<%=itemCategory%> | 店名検索キーワード：<%=userName%></h3>
			<div class="items">
			
<% ArrayList<UserInfoBean> itemList=(ArrayList<UserInfoBean>) request.getAttribute("itemList"); 

if (itemList == null || itemList.size() == 0){
	%>			

					<h3>検索結果：なし</h3>

<% } else { %>

				
				
<%	for(int i=0; i<itemList.size(); i++){ %>				
				
				<div class="item">
					<%String itemID = Integer.toString(itemList.get(i).getUser_itemID()); %>
					<a href= "Seco_list?itemID=<%= itemID  %>">
					<p class="thum_img">
							<img src="images/item_img/<%= itemList.get(i).getUser_image() %>"
														alt="<%= itemList.get(i).getUser_itemName() %>">
						
						</p>
						
						<p>
							<%= itemList.get(i).getUser_itemName() %><br>
							<strong>\<%= itemList.get(i).getUser_price() %>
							-　残数 <%= itemList.get(i).getUser_stock() %></strong><br>
							-　残り <%= itemList.get(i).getUser_leftDays() %>日</strong><br>
							<%= itemList.get(i).getUser_userName() %><br>
							<span style="font-size: 0.8em;"><%= itemList.get(i).getUser_address() %></span>
						</p>
					</a>
				</div>
		<%} %>

				

			</div><!-- div class="items"ここまで -->
			
	<%} %>			
		</main>
		<!-- メインここまで -->
		<!-- フッター -->

		<footer>
			<div class="gotop">
				<a href="#top">
					<img src="images/gotop.svg" alt="トップページへ戻る。">
				</a>
			</div>
			<p class="copyright">SECO <span class="foot_joy">- Joy share -</span></p>
		</footer>
		<!-- フッターここまで -->	
	
	</body>
</html>