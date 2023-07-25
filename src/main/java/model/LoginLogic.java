package model;

import dao.SecoStoreDAO;

public class LoginLogic {
	public String execute(SecoStoreBeans user) {
		SecoStoreDAO DAO = new SecoStoreDAO();
		String eMsg = "";
		String userName = DAO.execute(user);
		if (userName != null) {
			//ユーザーいる。ユーザー情報を商品登録画面に送る
			return userName;
		}else {
			//ユーザーいない。元の画面にフォワードして、失敗しました。を表示
			//エラーメッセージをリクエストスコープにいれておいて、それをjspに表示させる。
			//nullならエラーなし。null以外ならエラーでひょうじさせる。
			//リクエストスコープに保存
			return null;
		}
		
	}
}
