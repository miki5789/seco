package servlet;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.GetSecoGoodsListLogic;
import model.PostSecoGoodsLogic;
import model.SecoGoodsBeans;

@WebServlet("/Seco_goods")
@MultipartConfig
public class Seco_goods extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Seco_goods:doPost() START");

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String itemName = request.getParameter("itemName");	// 商品名
		String itemCategory = request.getParameter("itemCategory");	// 商品カテゴリ
		String sprice = request.getParameter("price");			// 商品価格
		String sstock = request.getParameter("stock");			// 在庫数
		String itemTitle = request.getParameter("itemTitle");	// 商品タイトル
		String itemComment = request.getParameter("itemComment");		// 商品説明
		//String image = request.getParameter("image");	// 商品画像
		String sleftDays = request.getParameter("leftDays");	// 残日数
		String endDate = request.getParameter("endDate"); //終了日

		int price = 0;
		int stock = 0;
		int leftDays = 0;
		
		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part=request.getPart("pict");
		
		System.out.println(part);
		//アップロードするフォルダ		
		String filename=part.getSubmittedFileName();//ie対応が不要な場合
		//String file = "/images/item_img/" + part.getSubmittedFileName();
		//String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//実際にファイルが保存されるパス確認
		System.out.println("path;" + filename);
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/images/item_img");
		String image = filename;
		//書き込み
		part.write(path+File.separator+filename);
		
        //元のパスを取得するFileオブジェクトの宣言
        File origin = new File(filename);

        //絶対パスを取得
        String originpath = origin.getAbsolutePath();

	
		 
		/*
		String filePath = "/images/item_img/" + part.getSubmittedFileName();
		part.write(getServletContext().getRealPath(filePath));
		function.accept(filePath);
		*/
		
		// セッションスコープからユーザ情報を取得
		System.out.println("hi");
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("ss_userID");
		System.out.println("userID;" + userID);
		/*
		 String itemID =  loginUser.getSecoStoreitemID();
		int sleftDays = 0;
		String endDate = "将来用";		// 販売終了日
		int stringPrice = 0;
		int sstock = 0;
		*/

		// 入力値チェック
		int		iErrorBit = 0;
		if (itemName == null || itemName.length() == 0) {
			iErrorBit |= 0x0001;
			System.out.println("ERROR:itemName");
		}
		if (itemCategory == null || itemCategory.length() == 0) {
			iErrorBit |= 0x0002;
			System.out.println("ERROR:itemCategory");
		}
		if (sprice == null || sprice.length() == 0) {
			iErrorBit |= 0x0004;
			System.out.println("ERROR:price");
		}
		else {
			try{
				price = Integer.parseInt(sprice);
				System.out.println(sprice);
			}
			catch (NumberFormatException ex){
				//ex.printStackTrace();
				iErrorBit |= 0x0004;
				System.out.println("ERROR:price");
			}
		}
		if (sstock == null || sstock.length() == 0) {
			iErrorBit |= 0x0008;
			System.out.println("ERROR:stock");
		}
		else {
			try{
				stock = Integer.parseInt(sstock);
				System.out.println(sstock);
			}
			catch (NumberFormatException ex){
				//ex.printStackTrace();
				iErrorBit |= 0x0008;
				System.out.println("ERROR:stock");
			}
		}
		//itemTitle = "将来用";		// 商品タイトル
		//if (itemTitle == null || itemTitle.length() == 0) {
		//	iErrorBit |= 0x010;
		//	System.out.println("ERROR:itemTitle");
		//}
		if (itemComment == null || itemComment.length() == 0) {
			iErrorBit |= 0x0020;
			System.out.println("ERROR:itemComment");
		}
		if (image == null || image.length() == 0) {
			iErrorBit |= 0x0080;
			System.out.println("ERROR:image");
		}
		if (sleftDays == null || sleftDays.length() == 0) {
			iErrorBit |= 0x0100;
			System.out.println("ERROR:leftDays");
		}
		else {
			try{
				leftDays = Integer.parseInt(sleftDays);
				System.out.println(sleftDays);
				if(leftDays > 7) {
					iErrorBit |= 0x0100;
					System.out.println("ERROR:leftDays");
				}
			}
			catch (NumberFormatException ex){
				//ex.printStackTrace();
				iErrorBit |= 0x0100;
				System.out.println("ERROR:leftDays");
			}
		}

		if(iErrorBit == 0) {
			// 商品データをリストに追加
			SecoGoodsBeans secoGoodsB = new SecoGoodsBeans(userID,itemName
					,itemCategory,price,stock,itemTitle,itemComment,image,leftDays,endDate);
			PostSecoGoodsLogic postSecoGoodsLogic = new PostSecoGoodsLogic();
			postSecoGoodsLogic.execute(secoGoodsB);
			
			// リストを取得して、リクエストスコープに保存
			GetSecoGoodsListLogic getSecoGoodsListLogic = new GetSecoGoodsListLogic();
			//findallを実行、最後の登録を取得
			List<SecoGoodsBeans> secoGoodsBList = getSecoGoodsListLogic.execute();
			request.setAttribute("secoGoodsBList", secoGoodsBList);
			
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Index");
			dispatcher.forward(request, response);
		}
		else {
			// 入力して他データをリストに追加
			SecoGoodsBeans secoGoodsB = new SecoGoodsBeans(userID,itemName
					,itemCategory,price,stock,itemTitle,itemComment,image,leftDays,endDate);
			
			String errorMsg = "入力エラーがあります";
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("secoGoodsB", secoGoodsB);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seco_goods.jsp");
			dispatcher.forward(request, response);
		}




	}

}
