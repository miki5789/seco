
package model;

import java.io.Serializable;

public class UserInfoBean implements Serializable {
//フィールド
	
	private int user_itemID; 
//	private String user_itemTitle;
	private String user_itemName; 
	private int user_stock; 
	private String user_address;
	private String user_userName;
	private String user_price;
	private String user_shopComment;
	private int user_leftDays;
	private String user_mail;
	private String user_phone;
	private String user_image; 
	private String user_postCode;
	//private String user_itemTitle;
	private String user_itemComment;

	
	//コンストラクタ
	public UserInfoBean(){}
	public UserInfoBean(int itemID, String itemName, int stock, String address, String userName,
	String price, String shopComment, int leftDays, String mail, String phone, String image, String postCode){
		this.user_itemID=itemID;
		this.user_stock=stock;
	//	this.user_itemTitle=itemTitle;
		this.user_itemName=itemName;
		this. user_shopComment=shopComment;
		this.user_leftDays=leftDays;
		this.user_mail=mail;
		this.user_phone=phone;
		this.user_postCode=postCode;
		this.user_userName=userName;
		this.user_address=address;
		this.user_price = price;
		this.user_image = image;
	}

	//コンストラクタ - 検索結果用
	public UserInfoBean(int itemID, String itemName, int stock, String userName, 
			String address, String price, String image, int leftDays) {
		this.user_itemID = itemID;
		this.user_itemName=itemName;
		this.user_stock=stock;
		this.user_userName=userName;
		this.user_address=address;
		this.user_price = price;
		this.user_image = image;
		this.user_leftDays = leftDays;
	}	
	
	
	//コンストラクタ - 商品詳細用
	public UserInfoBean(String itemName, String price, int stock, int leftDays, String userName, 
			String address, String phone, String mail, String shopComment, String image, String itemComment) {	
		//this.user_itemTitle = itemTitle;
		this.user_itemName = itemName;
		this.user_price = price;
		this.user_stock=stock;
		this.user_leftDays = leftDays;
		this.user_userName=userName;
		this.user_image = image;
		this.user_address = address;
		this.user_phone = phone;
		this.user_mail = mail;
		this.user_shopComment = shopComment;
		this.user_itemComment = itemComment;
	}

	
	//商品IDnoゲッター/セッターを作成
	public Integer getUser_itemID() {
		return user_itemID;
	}
	public void setUser_itemID(Integer itemID) {
		this.user_itemID=itemID;
	}
//	商品ネームのゲッター/セッター作成
	public String getUser_itemName() {
		return user_itemName;
	}
	public void setUser_itemName(String itemName) {
		this.user_itemName=itemName;
	}
	
	//店舗名（ユーザー名）のゲッター/セッターを作成
	public String getUser_userName() {
		return user_userName;
	}
	public void setUser_userName(String userName) {
		this.user_userName=userName;
	}
	
	//在庫数のゲッター/セッターを作成
	public int getUser_stock() {
		return user_stock;
	}
	public void setUser_stock(int stock) {
		this.user_stock=stock;
	}
	
	//住所のゲッター/セッターを作成
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String address) {
		this.user_address=address;
	}
	
	//価格のゲッター/セッターを作成
	public String getUser_price() {
		return user_price;
	}
	public void setUser_price(String price) {
		this.user_price = price;
	}
		
	//イメージ名のゲッター/セッターを作成
	public String getUser_image() {
		return user_image;
	}
	public void setUser_image(String image) {
		this.user_image = image;
	}
	//ショップコメントのゲッター/セッタを作成
	public String getUser_shopComment(){
		return user_shopComment;
		}
	public void setUser_shopComment(String shopComment){		
		this.user_shopComment=shopComment;
}
	//商品コメントのゲッター/セッタを作成
	public String getUser_itemComment(){
		return user_itemComment;
		}
	public void setUser_itemComment(String itemComment){		
		this.user_itemComment=itemComment;
	}	
	
	public int getUser_leftDays() { return user_leftDays; }
	public String getUser_postCode() { return user_postCode; }
	public String getUser_phone()    { return user_phone; }
	public String getUser_mail()     { return user_mail; }

	public void setUser_leftDays (int leftDays){this.user_leftDays=leftDays;}
	public void setUser_postCode (String postCode){this.user_postCode=postCode;}
	public void setUser_phone    (String phone){this.user_phone=phone;}
	public void setUser_mail     (String mail){this.user_mail=mail;}

	
}
