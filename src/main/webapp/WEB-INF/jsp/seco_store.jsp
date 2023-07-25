<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SECO</title>
<link rel="stylesheet" href="css/seco_style.css">
</head>
<body>
<h1>店舗／ユーザー登録</h1>
<p>
<a href="/JS/Seco_logout">ログアウト</a>
</p>
<form action="/JS/Seco_store" method="post">
			<table class="general">
				<tr>
					<th>アカウント名</th>
					<td  style="display: flex;">
						<input type="text" name="userID">&nbsp;&nbsp;</td>
						<th>パスワード</th>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<th>店舗名／氏名</th>
					<td colspan="3"><input type="text" name="userName"></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td colspan="3"><input type="text" name="postCode"></td>
				</tr>
				<tr>
					<th>地域</th>
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
				</tr>
				<tr>
					<th>地域以降の住所</th>
					<td colspan="3"><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td colspan="3"><input type="text" name="phone"></td>
				</tr>
                <tr>
                    <th>店舗コメント</th>
                    <td colspan="3"><textarea name="shopComment" id="shopComment"></textarea></td>
                </tr>             
				<tr>
					<th>メールアドレス</th>
					<td colspan="3"><input type="text" name="mail"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="登録"></td>
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
<c:if test="${not empty errorMsg }">
	<p>${errorMsg}</p>
</c:if>
<c:forEach var="secoStoreB" items="${secoStoreBList}">
	<p><c:out value="${secoStoreB.userID}" />
		<c:out value="${secoStoreB.mail}" /></p>
</c:forEach>
</body>
</html>