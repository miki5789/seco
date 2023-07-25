package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import model.UserInfoBean;

@WebServlet("/Seco_list")
public class Seco_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータ（クリックされた商品のアイテムID）の取得
		request.setCharacterEncoding("UTF-8");
		String sitemID = request.getParameter("itemID");
		int itemID = Integer.parseInt(sitemID);
		String price = request.getParameter("price");

		//入力値をプロパティに設定
		UserInfoBean itemInfo = new UserInfoBean();
		ItemDAO DAO = new ItemDAO();
		itemInfo = DAO.execute(itemID);
		
		//リクエストスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("itemInfo", itemInfo);
		System.out.println("itemID;" + itemID);
		session.setAttribute("itemID", itemID);
		session.setAttribute("price", price);
		

		// 検索結果にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_disp.jsp");
		dispatcher.forward(request, response);
	}
}
