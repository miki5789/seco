package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.SecoStoreBeans;

@WebServlet("/Seco_login")
public class Seco_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String pass = request.getParameter("pass");
		String btn = request.getParameter("btn");
		
		if (btn.equals("ログイン")) {
		
			// Userインスタンス（ユーザー情報）の生成
			SecoStoreBeans user = new SecoStoreBeans(userID, pass);
			
			// ログイン処理
			LoginLogic loginLogic = new LoginLogic();
			String userName = loginLogic.execute(user);

			// ログイン成功したら
			if(userName != null) {
				
				// ユーザーのログイン情報(ID&pass)を渡して、商品登録画面にフォワード
				user.setSecoStoreuserName(userName); //もともとあったuser(id&pass)にuserNameを追加した。これで３つになった
				HttpSession session = request.getSession();
				session.setAttribute("ss_userID",userID);
				session.setAttribute("user", user);
				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_goods.jsp");
				dispatcher.forward(request, response);
				
			}else { //ログイン失敗したら
				System.out.println("test3");
				// 失敗しましたのメッセージをセッションスコープに保存
				String eMsg = "ログインに失敗しました。IDまたはパスワードが正しくありません。";
				request.setAttribute("eMsg", eMsg); //前はキー（検索する）、後ろはvalue
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("seco_login.jsp");
				dispatcher.forward(request, response);
			}
		}else if(btn.equals("新規登録")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_store.jsp");
			dispatcher.forward(request, response);
		}
	}

}
