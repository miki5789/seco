package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SecoGoodsBeans;

public class SecoGoodsDAO {
	// データベース接続に試用する情報
	private final String JDBC_URL = "jdbc:sqlite:e:/Study/SQL/seco_db.db";
	
	public List<SecoGoodsBeans> findAll() {
		List<SecoGoodsBeans> SecoGoodsBList = new ArrayList<>();
		System.out.println("SecoGoodsDAO:findAll() START");
		// データベース接続
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(JDBC_URL);
			
			// SELECT文の準備
			String sql = "SELECT userID,itemTitle,itemName,"
					+ "stock, price, itemCategory, itemComment, image, leftDays, endDate "
					+ "FROM itemTable ORDER BY itemID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();
			
			// SELECT文の結果をArrayLitに格納
			if (rs.next()) {
				//int itemID = rs.getInt("itemID");
				String userID = rs.getString("userID");		// アカウント名
				String itemName = rs.getString("itemName");
				String itemCategory = rs.getString("itemCategory");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				String itemTitle = rs.getString("itemTitle");
				String itemComment = rs.getString("itemComment");
				String image = rs.getString("image");
				int leftDays = rs.getInt("leftDays");
				String endDate = rs.getString("endDate");
				System.out.println(itemName);
				SecoGoodsBeans SecoGoodsB = new SecoGoodsBeans(userID,itemName
						,itemCategory,price,stock,itemTitle,itemComment,image,leftDays,endDate);
				SecoGoodsBList.add(SecoGoodsB);
			}
			
			conn.close();
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return SecoGoodsBList;
	}
	
	public boolean create(SecoGoodsBeans secoGoodsB) {
		System.out.println("SecoGoodsDAO:create() START");
		// データベース接続
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(JDBC_URL);
			
			// INSERT文の準備(idは自動連番なので指定しなくてよい)
			String sql = "INSERT INTO itemTable(userID,itemName,itemCategory,price,stock,"
					+ "itemTitle,itemComment,image,leftDays,endDate)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に試用する値を設定しSQLを完成
			//pStmt.setInt(1, secoGoodsB.getSecoGoodsitemID());
			pStmt.setString(1, secoGoodsB.getSecoGoodsuserID());
			pStmt.setString(2, secoGoodsB.getSecoGoodsitemName());
			pStmt.setString(3, secoGoodsB.getSecoGoodsitemCategory());
			pStmt.setInt(4, secoGoodsB.getSecoGoodsprice());
			pStmt.setInt(5, secoGoodsB.getSecoGoodsstock());
			pStmt.setString(6, secoGoodsB.getSecoGoodsitemTitle());	// 将来用
			pStmt.setString(7, secoGoodsB.getSecoGoodsitemComment());
			pStmt.setString(8, secoGoodsB.getSecoGoodsimage());
			pStmt.setInt(9, secoGoodsB.getSecoGoodsleftDays());
			pStmt.setString(10, secoGoodsB.getSecoGoodsendDate());	// 将来用
			
			// INSERT文を実行
			int result = pStmt.executeUpdate();
			System.out.println("result;"+result);
			conn.close();
			
			if (result != 0) {
				return true;
			}else {
				return false;
			}
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
