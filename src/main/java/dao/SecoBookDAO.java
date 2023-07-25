package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecoBookDAO {
	final String JDBC_URL = "jdbc:sqlite:e:/Study/SQL/seco_db.db";
	//予約データベースに追加
	public boolean execute(int itemID, int unit, int price) {
	
	int sumPrice = price * unit;
	String item_status = "";
	String userName = "";
	
	//データベースへ接続
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		//SELECT文を準備
			String sql = "INSERT INTO bookTable(itemID,unit,sumPrice) "
					+ "VALUES(" + itemID +", " + unit +", " + sumPrice + ");";

			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//INSERT文を実行し、結果表を取得
			
			int rs = pStmt.executeUpdate();
			conn.close();
			
			
			if (rs != 0) {
				return true;
			}else {
				return false;
			}
			
			}catch (ClassNotFoundException e){
				e.printStackTrace();
				return false;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
	}	
	//予約番号発行
	public int execute() {

	//データベースへ接続
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		//SELECT文を準備
			String sql = "SELECT bookNo FROM bookTable ORDER BY bookNo DESC LIMIT 1;";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			System.out.println(sql);
			
			//結果表に格納されたレコードの内容を
			//〇〇インスタンスに設定し、ArrayListインスタンスに追加
			if (rs.next()) {
				int user_bookNo = rs.getInt("bookNo");
				return user_bookNo;
			}
			conn.close();
			}catch (ClassNotFoundException e){
				e.printStackTrace();
				return 0;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return 0;
			}
		return 0;
	}
}


