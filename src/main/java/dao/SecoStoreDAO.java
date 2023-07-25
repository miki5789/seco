//会員登録をするためのDAO
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SecoStoreBeans;

public class SecoStoreDAO {
	private static final String userID = null;
		// データベース接続に試用する情報
		private final String JDBC_URL = "jdbc:sqlite:e:/Study/SQL/seco_db.db";
		
		public List<SecoStoreBeans> findAll() {
			List<SecoStoreBeans> SecoStoreBList = new ArrayList<>();
			System.out.println("SecoStoreDAO:findAll() START");
			// データベース接続
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection(JDBC_URL);
				
				// SELECT文の準備
			String sql = "SELECT userID, pass, userCategory, userName,"
					+ " postCode, area, address, phone, shopComment, mail"
					+ " FROM userTable ORDER BY userID DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				// SELECTを実行
				ResultSet rs = pStmt.executeQuery();
				
				// SELECT文の結果をArrayLitに格納
				while (rs.next()) {
					String userID = rs.getString("userID");		// アカウント名
					String pass = rs.getString("pass");		// パスワード
					String userCategory = rs.getString("userCategory"); 	// ユーザーカテゴリ
					String userName = rs.getString("userName");	// 店舗名／氏名
					String postCode = rs.getString("postCode");		// 郵便番号
					String area = rs.getString("area");		// 地域カテゴリ
					String address = rs.getString("address");		// 住所
					String phone = rs.getString("phone");		// 電話番号
					String shopComment = rs.getString("shopComment");	// 店舗コメント
					String mail = rs.getString("mail");		// メールアドレス
					
					SecoStoreBeans SecoStoreB = new SecoStoreBeans(userID,pass,userCategory,userName,postCode,area,address,phone,shopComment,mail );
					SecoStoreBList.add(SecoStoreB);
				}
				conn.close();
			}
			catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			
				return null;
			}
			return SecoStoreBList;
		}
		
		public boolean create(SecoStoreBeans secoStoreB) {
			System.out.println("SecoStoreDAO:create() START");
			// データベース接続
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection(JDBC_URL);
				
				// INSERT文の準備(idは自動連番なので指定しなくてよい)
			String sql = "INSERT INTO userTable(userID,pass,userCategory,userName,postCode,area,address,phone,shopComment,mail)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				// INSERT文中の「？」に試用する値を設定しSQLを完成
				pStmt.setString(1, secoStoreB.getSecoStoreuserID());
				pStmt.setString(2, secoStoreB.getSecoStorepass());
				pStmt.setString(3, secoStoreB.getSecoStoreuserCategory());
				pStmt.setString(4, secoStoreB.getSecoStoreuserName());
				pStmt.setString(5, secoStoreB.getSecoStorepostCode());
				pStmt.setString(6, secoStoreB.getSecoStorearea());
				pStmt.setString(7, secoStoreB.getSecoStoreaddress());
				pStmt.setString(8, secoStoreB.getSecoStorephone());
				pStmt.setString(9, secoStoreB.getSecoStoreshopComment());
				pStmt.setString(10, secoStoreB.getSecoStoremail());

				// INSERT文を実行
				int result = pStmt.executeUpdate();

				if (result != 1) {
				conn.close();
					return false;
				}
			conn.close();
			}
			catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		//ログイン用DAO
		public String execute(SecoStoreBeans user) {
			//データベースへ接続
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection(JDBC_URL);
				
				//SELECT文を準備
					String sql = "SELECT userID, pass, userName FROM userTable WHERE userID = \""
							+  user.getSecoStoreuserID() + "\" AND pass = \"" + user.getSecoStorepass() + "\"";
					System.out.println(sql);
				//SELECTを実行し、結果表を取得
					PreparedStatement pStmt = conn.prepareStatement(sql);
					ResultSet rs = pStmt.executeQuery();
					
				//ログインデータがあればユーザー名を送る
					if (rs.next()) {
						String userName = rs.getString("userName");
						System.out.println(userName);
						conn.close();
						return userName;
						
					} else {
						conn.close();
						return null;
					}	
					
			}
			catch (ClassNotFoundException e){
						e.printStackTrace();
						return null;
					}
					catch(SQLException e) {
						e.printStackTrace();
						return null;
					}
		}
	//ログイン用DAO
	public boolean user_check(String userID) {
			//データベースへ接続
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection(JDBC_URL);
				
				//SELECT文を準備
				String sql = "SELECT userName FROM userTable WHERE userID = \"" + userID + "\"";
				System.out.println(sql);
				//SELECTを実行し、結果表を取得
				PreparedStatement pStmt = conn.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();
					
				//ログインデータがあればユーザー名を送る
				if (rs.next()) {
					String userName = rs.getString("userName");
					System.out.println(userName);
					conn.close();
					return true;
				}
				else {
					conn.close();
					return false;
				}
			}
			catch (ClassNotFoundException e){
						e.printStackTrace();
						return false;
			}
			catch(SQLException e) {
						e.printStackTrace();
						return false;
			}
	}

}
