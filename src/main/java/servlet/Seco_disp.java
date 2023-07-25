package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SecoBookDAO;
import model.UserInfoBean;

@WebServlet("/Seco_disp")
public class Seco_disp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String sunit = request.getParameter("unit");
		
		if ((sunit == null) || (sunit == "")) {
			String Msg = "数量を入力してください。";
			request.setAttribute("Msg", Msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_disp.jsp");
			dispatcher.forward(request, response);
		}else {
			int unit = Integer.parseInt(sunit);
			
			HttpSession session = request.getSession();
			//itemID取得・int化
			UserInfoBean itemInfo = (UserInfoBean) session.getAttribute("itemInfo");
			int itemID = (int) session.getAttribute("itemID");
			
			//price取得・int化
			String sprice =  itemInfo.getUser_price();
			int price =  Integer.parseInt(sprice);
			//stock
			int stock =  itemInfo.getUser_stock();
			
			//注文数が在庫数より多ければ
			if (unit>stock) {
				//メッセージを作成
				String Msg = "在庫は" + stock + "です。<br>在庫数より小さい数を入力してください。";
				//スコープに保存
				request.setAttribute("Msg", Msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_disp.jsp");
				dispatcher.forward(request, response);
				
			}else {
				//入力値をプロパティに設定
				SecoBookDAO DAO = new SecoBookDAO();
				//データベースに追加
				boolean execute = DAO.execute(itemID, unit, price);
				
				//データベース追加成功したら
				if (execute == true) {
					//予約番号を取得
					int bookNo = DAO.execute();
					//メッセージを作成
					String Msg = "あなたの予約番号は" + bookNo + "です。";
					//スコープに保存
					request.setAttribute("Msg", Msg);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_disp.jsp");
					dispatcher.forward(request, response);
				}
			}
		}

	}
}
