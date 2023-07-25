<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="model.SecoStoreBeans" %>
<%@ page import="model.SecoGoodsBeans" %>
<%
// セッションスコープからユーザ情報を取得
SecoStoreBeans secoStoreBList = (SecoStoreBeans) request.getAttribute("secoStoreBList");
SecoGoodsBeans secoGoodsB = (SecoGoodsBeans) request.getAttribute("secoGoodsB");
SecoStoreBeans loginUser = (SecoStoreBeans) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SECO</title>
    <link rel="stylesheet" href="css/seco_style.css">
</head>
<body>

	<!-- ヘッダー -->	
	<jsp:include page="/WEB-INF/jsp/seco_header.jsp" />
	<!-- ヘッダーここまで -->
	
	<main>
		<% if(loginUser != null) { %>
		<form action="/JS/Seco_goods" method="post"  enctype="multipart/form-data">
		<h3><%= loginUser.getSecoStoreuserName() %>様　商品登録画面へようこそ</h3>
            <table class="general">
                <tr>
                    <th>商品名</th>
                    <td colspan="3"><input type="text" name="itemName" 
                    <% if (secoGoodsB != null){ %> value = <%= secoGoodsB.getSecoGoodsitemName() %>	<%	} %> ></td>
                    
                </tr>
                <tr>
                    <th>カテゴリ</th>
                    <td>	
                    	<select name="itemCategory" id="category">
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
			<td>&nbsp;</td>
                </tr>
                <tr>
                    <th>商品画像</th>
                    <td colspan="3"><input type="file" name="pict" accept="image/png, image/jpeg, image/jpg, image/gif" required></td>
                </tr>
                <tr>
                    <th>単価</th>
                     <td  style="display: flex;">
                      <input type="text" name="price"  <% if (secoGoodsB != null){ %> value = <%= secoGoodsB.getSecoGoodsprice() %>	<%	} %>>&nbsp;&nbsp;円</td>
                     <th>数量</th>
                    <td><input type="text" name="stock"  <% if (secoGoodsB != null){ %> value = <%= secoGoodsB.getSecoGoodsstock() %>	<%	} %>></td>
                </tr>
                <tr>
                    <th>販売期間</th>
                    <td>
                    	<select name="leftDays" style="width:100px;" <% if (secoGoodsB != null){ %> value = <%= secoGoodsB.getSecoGoodsleftDays() %>	<%	} %>>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
			 </select> 日             
                    </td>
                </tr>
                <tr>
                    <th>商品説明</th>
                    <td colspan="3"><textarea name="itemComment"  <% if (secoGoodsB != null){ %> value = <%= secoGoodsB.getSecoGoodsitemComment() %>	<%	} %>></textarea></td>
                </tr>
                <%
				String errorMsg = (String) request.getAttribute("errorMsg");
				if (errorMsg != null){ %>
						<p style = "color: red;"><%= errorMsg %></p>
				<%	} %>             
                 <tr>
                    <td>&nbsp;</td>
                    <td>
                    	<input type="submit" value="登録" class="toroku" style=""></td>
                    <td>&nbsp;</td>
                    <td>
                    	<a href="/JS/Seco_logout">
                    		<p class="logout">
                    			ログアウト
                    		</p>
                    	</a>
                    </td>
				</tr>
            </table>
</form>
<% }else{ %>
エラー
<% } %>	

<br>
<br>
			<!-- バナー広告 -->
			<!-- div bnr ここから-->
				<jsp:include page="/WEB-INF/jsp/seco_banner.jsp" />
			<!-- div bnr ここまで-->

	</main>
		<!-- フッター -->
		<jsp:include page="/WEB-INF/jsp/seco_footer.jsp" />
		<!-- フッターここまで -->

</body>
</html>