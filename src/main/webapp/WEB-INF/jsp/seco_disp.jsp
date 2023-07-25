<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, model.UserInfoBean" %>
<%@ page import = "model.SecoBookBeans" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SECO | 商品詳細 購入予約</title>
    <link rel="stylesheet" href="css/seco_style.css">
</head>
<body id="top">
    <!-- ヘッダー -->
	<jsp:include page="/WEB-INF/jsp/seco_header.jsp" />
    <!-- ヘッダーここまで -->
    <!--
    <h1 class="hero index">たのしい、ひとときを</h1>
     -->
    <!-- メイン -->
    <main>

<% UserInfoBean itemInfo = (UserInfoBean) session.getAttribute("itemInfo"); %>

        <div>
            <h2> <%= itemInfo.getUser_itemName() %></h2>
            <table class="shop-info">

                <tr>
                    <th>商品コメント</th>
                    <td colspan="2"><%=  itemInfo.getUser_itemComment() %></td>
                    
                </tr>
                <tr>
                    <th>価格</th>
                    <td><%= itemInfo.getUser_price() %></td>
                    <td rowspan="7"><img src="images/item_img/<%= itemInfo.getUser_image() %>" alt= "商品画像"></td>

                </tr>
                <tr>
                    <th>残数</th>
                    <td><%= itemInfo.getUser_stock() %></td>
                </tr>
                <tr>
                    <th>販売期間</th>
                    <td><%= itemInfo.getUser_leftDays() %></td>
                </tr>
                <tr>
                    <th>販売店</th>
                    <td><%= itemInfo.getUser_userName() %></td>
                </tr>
                <tr>
                    <th>住所</th>
                    <td><%= itemInfo.getUser_address() %></td>
                </tr>
                <tr>
                    <th>電話番号</th>
                    <td><%= itemInfo.getUser_phone() %></td>
                </tr>
                 <tr>
                    <th>メールアドレス</th>
                    <td><%= itemInfo.getUser_mail() %></td>
                </tr>              
                 <tr>
                    <th>店舗コメント</th>
                    <td colspan="2"><%= itemInfo.getUser_shopComment() %></td>
                
            </table>
        </div>
        <br>
        <br>
        
		<form action="/JS/Seco_disp" method="post" class="general" 
			style="background-color: #ffffff;
					text-align: right;
					width: 100%;">
			<b>数量：</b><input type="text"  style="width: 100px;" name="unit">
			<input type="submit" value="購入予約" style="margin-left: 100px;">
		</form>
		
				<%
		String Msg = (String) request.getAttribute("Msg");
		if (Msg != null){ %>
				<p style = "color: red;"><%= Msg %></p>
		<%	} %>
				
    </main>
    <!-- メインここまで -->
    <!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/seco_footer.jsp" />
    <!-- フッターここまで -->
</body>
</html>
