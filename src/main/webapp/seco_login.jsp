<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "servlet.Seco_login" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SECO | ログイン</title>

	<style>
		
		h2 {
			color: #333333;
		}
		
		main form input[type="text"], input[type="password"] {
		padding: 6px;
	 	width: 30%;
	 	font-size: 1.1rem;
			} 
	</style>
        
</head>
<body>
	<!-- ヘッダー -->	
	<jsp:include page="/WEB-INF/jsp/seco_header.jsp" />
	<!-- ヘッダーここまで -->

		<main>

			
			<form action="/JS/Seco_login" method="post">
				<h2>ログイン画面</h2>
			    <br>
			    <br>
				アカウント名：<input type="text" name="userID">
				英(大小)/数/記号(_.-)
				<br>
				<br>
				
				パスワード：&emsp;<input type="password" name="pass">
				英(大小)/数/記号(_.-)
				<br>
				
				<%
				String eMsg = (String) request.getAttribute("eMsg");
				if (eMsg != null){ %>
						<p style = "color: red;"><%= eMsg %></p>
				<%	} %>
				
				<br>
				<br>
				<input type="submit" name = "btn" value="ログイン">
				<input type="submit" name = "btn" value="新規登録">
			</form>

			
			<br>
			<br>
			<br>			
			

			
		</main>



	<!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/seco_footer.jsp" />
	<!-- フッターここまで -->
</body>
</html>