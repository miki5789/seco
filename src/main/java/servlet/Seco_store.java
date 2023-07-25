package servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SecoStoreDAO;
import model.GetSecoStoreListLogic;
import model.PostSecoStoreLogic;
import model.SecoStoreBeans;

/**
 * Servlet implementation class Seco_store
 */
@WebServlet("/Seco_store")
public class Seco_store extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Seco_store:doPost() START");

		final String TEXT_REGEX = "[0-9a-zA-Z\\-\\_\\.]+";	// "0-9"|"a-z"|"A-Z"|"."|"_"|"-"
		final Pattern TEXT_PATTERN = Pattern.compile(TEXT_REGEX);

		final String POST_REGEX = "^[0-9]{3}-[0-9]{4}$";		// "999-9999"
		final Pattern POST_PATTERN = Pattern.compile(POST_REGEX);

		final String TEL_REGEX = "^[0-9]{2,4}-[0-9]{3,4}-[0-9]{3,4}$";
		final Pattern TEL_PATTERN = Pattern.compile(TEL_REGEX);

		final String MAIL_REGEX = "^[a-zA-Z0-9_.+-]+@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$";
		final Pattern MAIL_PATTERN = Pattern.compile(MAIL_REGEX);

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userID  = request.getParameter("userID");		// アカウント名
		String pass     = request.getParameter("pass");			// パスワード
		String userName = request.getParameter("userName"); 	// 店舗名／氏名
		String spostCode = request.getParameter("postCode");	// 郵便番号
		String area  = request.getParameter("area");			// 住所
		String address  = request.getParameter("address");		// 住所
		String phone    = request.getParameter("phone");		// 電話番号
		String shopComment = request.getParameter("shopComment");	// 店舗コメント
		String mail     = request.getParameter("mail");			// メールアドレス
		
		// 地域カテゴリの抽出
		//String userCategory = request.getParameter("userCategory");	// ユーザーカテゴリ
		String userCategory = "1";	// ユーザーカテゴリ　1固定
		String postCode = request.getParameter("postCode");

		// 入力値チェック
		int		iErrorBit = 0;
		//アカウントID
		if (userID == null) {
			iErrorBit |= 0x0001;
			System.out.println("ERROR:userID");
		}
		else {
			// ログイン処理
			SecoStoreDAO loginCheck = new SecoStoreDAO();
			boolean bret = loginCheck.user_check(userID);

			// ログイン成功したら既に登録あり
			if(bret == true) {
				iErrorBit |= 0x0001;
				System.out.println("ERROR:userID Used");
			}
			else {
				if (TEXT_PATTERN.matcher(userID).matches()) {
					System.out.println("OK:userID:" + userID);
				}
				else {
					iErrorBit |= 0x0001;
					System.out.println("ERROR:userID Text:" + userID);
				}
		}
		}
		//パスワード
		if (pass == null) {
			iErrorBit |= 0x0002;
			System.out.println("ERROR:pass");
		}
		else {
			if (TEXT_PATTERN.matcher(pass).matches()) {
				System.out.println("OK:pass:" + pass);
			}
			else {
				iErrorBit |= 0x0002;
				System.out.println("ERROR:pass Text:" + pass);
			}
		}
		//店舗名称
		if (userName == null) {
			iErrorBit |= 0x0004;
			System.out.println("ERROR:userName");
		}
		//郵便番号
		if (spostCode == null || spostCode.length() != 8) {
			iErrorBit |= 0x0008;
			System.out.println("ERROR:postCode");
		}
		else {
			if (POST_PATTERN.matcher(spostCode).matches()) {
				System.out.println("OK:spostCode:" + spostCode);
			}
			else {
				iErrorBit |= 0x0008;
				System.out.println("ERROR:spostCode Text:" + spostCode);
			}
		}
		//住所
		if (address == null || address.length() == 0) {
			iErrorBit |= 0x020;
			System.out.println("ERROR:address");
		}
		else {
			address = area+address;
		}
		//電話番号
		if (phone == null || phone.length() == 0) {
			iErrorBit |= 0x0040;
			System.out.println("ERROR:phone");
		}
		else {
			if (TEL_PATTERN.matcher(phone).matches()) {
				System.out.println("OK:phone:" + phone);
			}
			else {
				iErrorBit |= 0x0040;
				System.out.println("ERROR:phone Text:" + phone);
			}
		}
		//コメント
		if (shopComment == null || shopComment.length() == 0) {
			iErrorBit |= 0x0080;
			System.out.println("ERROR:shopComment");
		}
		//メアド
		if (mail == null || mail.length() == 0) {
			iErrorBit |= 0x0100;
			System.out.println("ERROR:mail");
		}
		else {
			if (MAIL_PATTERN.matcher(mail).matches()) {
				System.out.println("OK:mail:" + mail);
			}
			else {
				iErrorBit |= 0x0100;
				System.out.println("ERROR:pass mail:" + mail);
			}
		}
		
		if(iErrorBit == 0) {
			SecoStoreBeans secoStoreB = new SecoStoreBeans(userID,pass
					,userCategory,userName,postCode,area,address,phone,shopComment,mail);
			PostSecoStoreLogic postSecoStoreLogic = new PostSecoStoreLogic();
			postSecoStoreLogic.execute(secoStoreB);
		}
		else {
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg","入力エラーがります");
			System.out.println("ERROR:iErrorBit="+iErrorBit);
		}

		// リストを取得して、リクエストスコープに保存
		GetSecoStoreListLogic getSecoStoreListLogic = new GetSecoStoreListLogic();
		List<SecoStoreBeans> secoStoreBList = getSecoStoreListLogic.execute();
		request.setAttribute("secoStoreBList", secoStoreBList);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_register.jsp");
		dispatcher.forward(request, response);
	}

}
