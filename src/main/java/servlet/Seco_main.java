package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.UserInfoBean;

/**
 * Servlet implementation class Seco_main
 */
@WebServlet("/Seco_main")
public class Seco_main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String itemCategory = request.getParameter("category");
		String area = request.getParameter("area");


		//入力値をプロパティに設定
		List<UserInfoBean> itemList = new ArrayList<>();
		ItemDAO DAO = new ItemDAO();
		itemList = DAO.execute(userName, itemCategory, area);

		//リクエストスコープに保存
		request.setAttribute("itemList", itemList);
		request.setAttribute("userName", userName);
		request.setAttribute("itemCategory", itemCategory);
		request.setAttribute("area", area);
		
		// 検索結果にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_list.jsp");
		dispatcher.forward(request, response);
			
	}

}
