<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UserInfoBean,java.util.ArrayList" %>

<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content= "width=device-width, initial-scale=1">
		<title>SECO 商品＆店舗検索</title>
		<style>
		
		table.general tr th {
			background-color: #FFFFFF;
			color: #333333;
			font-size: 1.3rem;
		}
		
         p.search{
            
/*             color: black;  */
/*             font-size: 20px; */
/*             background-color: #FFFFFF;  */
/*             padding: 20px; */
         }
         p.login{
            

/*             background-color: #0000ff;  */
/*             padding: 20px; */
/*             text-align: center; */
         }     
             
        </style>
		<link rel="stylesheet" href="css/seco_style.css">
		<link href="https://fonts.googleapis.com/css?family=Cherry+Swash:700" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Homemade+Apple" rel="stylesheet">
	</head>
	
	<body id="top">
		<!-- ヘッダー -->	
		<jsp:include page="/WEB-INF/jsp/seco_header.jsp" />
		<!-- ヘッダーここまで -->		
			
		<h1 class="hero contact"></h1>
		<main>
			<h2>商品検索画面</h2>
			<br><br><br>
			<form action="Seco_main" method="post">
				
            <table class="general">
                <tr>
                    <th><label>地域</label></th>
                    <th><label for="kind">カテゴリ</label></th>
                    <th><label>店舗名</label></th>
                </tr>
                <tr>
                    <td>
						<select name="area"  id="area">
							<option value="">選択してください</option>
							<option value="大阪市北区">大阪市北区</option>
							<option value="大阪市都島区">大阪市都島区</option>
							<option value="大阪市福島区">大阪市福島区</option>
							<option value="大阪市此花区">大阪市此花区</option>
							<option value="大阪市此花区">大阪市中央区</option>
							<option value="大阪市西区">大阪市西区</option>
							<option value="大阪市港区">大阪市港区</option>
							<option value="大阪市大正区">大阪市大正区</option>
							<option value="大阪市天王寺区">大阪市天王寺区</option>
							<option value="大阪市浪速区">大阪市浪速区</option>
							<option value="大阪市西淀川区">大阪市西淀川区</option>
							<option value="大阪市淀川区">大阪市淀川区</option>
							<option value="大阪市東淀川区">大阪市東淀川区</option>
							<option value="大阪市東成区">大阪市東成区</option>
							<option value="大阪市生野区">大阪市生野区</option>
							<option value="大阪市旭区">大阪市旭区</option>
							<option value="大阪市城東区">大阪市城東区</option>
							<option value="大阪市鶴見区">大阪市鶴見区</option>
							<option value="大阪市阿倍野区">大阪市阿倍野区</option>
							<option value="大阪市住之江区">大阪市住之江区</option>
							<option value="大阪市住吉区">大阪市住吉区</option>
							<option value="大阪市東住吉区">大阪市東住吉区</option>
							<option value="大阪市平野区">大阪市平野区</option>
							<option value="大阪市西成区">大阪市西成区</option>
							<option value="堺市北区">堺市北区</option>
							<option value="堺市堺区">堺市堺区</option>
							<option value="堺市中区">堺市中区</option>
							<option value="堺市東区">堺市東区</option>
							<option value="堺市南区">堺市南区</option>
							<option value="堺市美原区">堺市美原区</option>
							<option value="岸和田市">岸和田市</option>
							<option value="池田市">池田市</option>
							<option value="吹田市">吹田市</option>
							<option value="泉大津市">泉大津市</option>
							<option value="貝塚市">貝塚市</option>
							<option value="守口市">守口市</option>
							<option value="枚方市">枚方市</option>
							<option value="茨木">茨木</option>
							<option value="八尾市">八尾市</option>
							<option value="泉佐野市">泉佐野市</option>
							<option value="寝屋川市">寝屋川市</option>
							<option value="河内長野市">河内長野市</option>
							<option value="松原市">松原市</option>
							<option value="和泉市">和泉市</option>
							<option value="箕面市">箕面市</option>
							<option value="柏原市">柏原市</option>
							<option value="羽曳野市">羽曳野市</option>
							<option value="門真市">門真市</option>
							<option value="摂津市">摂津市</option>
							<option value="高石市">高石市</option>
							<option value="藤井寺市">藤井寺市</option>
							<option value="東大阪市">東大阪市</option>
							<option value="泉南市">泉南市</option>
							<option value="四条畷市">四条畷市</option>
							<option value="交野市">交野市</option>
							<option value="大阪狭山市">大阪狭山市</option>
							<option value="阪南市">阪南市</option>
							<option value="島本町">島本町</option>
							<option value="忠岡町">忠岡町</option>
							<option value="熊取町">熊取町</option>
							<option value="岬町">岬町</option>
							<option value="河南町">河南町</option>
							<option value="千早赤阪村">千早赤阪村</option>
						</select>                    
                    </td>
                    <td>
						<select name="category" id="category">
							<option value="">選択してください</option>
							<option value="お弁当">お弁当</option>
							<option value="パン類">パン類</option>
							<option value="お惣菜">お惣菜</option>
							<option value="お酒">お酒</option>
							<option value="ドリンク">ドリンク</option>
							<option value="野菜・果物">野菜・果物</option>
							<option value="お菓子">お菓子</option>
							<option value="その他">その他</option>
						</select>                    
                    </td>
                    <td>
						<input type="text" name="userName"  placeholder="手入力 (省略可)">                    
                    </td>
                </tr>
                 <tr>
                    <td>
               			<p class="submit">
							<input type="submit" value="商品検索" class="toroku">
						</p>	   
                    </td>
                    <td>&nbsp;</td>
                    <td>
						<a href="seco_login.jsp">
							<p	class="login">
								ログイン
							</p>
						</a> 
                    </td>
				</tr>                            
			</table>			

			</form>
			
			<br>
			<br>
			<br>			
			
			<!-- バナー広告 -->
			<!-- div bnr ここから-->
				<jsp:include page="/WEB-INF/jsp/seco_banner.jsp" />
			<!-- div bnr ここまで-->
			
			<!-- 新しく登録された商品 -->
			<h2>最近登録された商品</h2>
			
			<div class="new_items">
			<% ArrayList<UserInfoBean> newList=(ArrayList<UserInfoBean>) 
			request.getAttribute("newList"); 
			if (newList == null || newList.size() == 0){
				%>	
			<h3>エラー</h3>
			<% } else { %>					
			<%	for(int i=0; i<newList.size(); i++){ %>				
							
					<div class="new_item">
						<a href= "Seco_list?itemID=<%= newList.get(i).getUser_itemID() %>">
						<p class="thum_img">
								<img src="images/item_img/<%= newList.get(i).getUser_image() %>"
													alt="<%= newList.get(i).getUser_itemName() %>">
							</p>
							<p><strong>
								<%= newList.get(i).getUser_itemName() %><br>
								\<%= newList.get(i).getUser_price() %>
							-　<br>残数 <%= newList.get(i).getUser_stock() %>
							-　残り <%= newList.get(i).getUser_leftDays() %>日</strong>
<%-- 								<%= newList.get(i).getUser_userName() %><br> --%>
<%-- 								<span style="font-size: 0.8em;"><%= newList.get(i).getUser_address() %></span> --%>
							</p>
						</a>
					</div>
						<%} %>		
					<%} %>	
						</div><!-- div class="items"ここまで -->
			
		</main>
		<!-- メインここまで -->
		

		<!-- フッター -->
		<jsp:include page="/WEB-INF/jsp/seco_footer.jsp" />
		<!-- フッターここまで -->
		
	</body>
</html>