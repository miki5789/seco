package model;

import java.io.Serializable;

public class SecoStoreBeans implements Serializable {
	private String userID  = "";		// アカウント名
	private String pass    = "";		// パスワード
	private String userName = ""; 		// 店舗名／氏名
	private String postCode   = "";		// 郵便番号
	private String address  = "";		// 住所
	private String phone    = "";		// 電話番号
	private String mail     = "";		// メールアドレス
	private String shopComment = "";	// 店舗コメント
	//private String LineNo   = "";		// 通し番号	
	private String area     = "";		// 地域カテゴリ	
	private String userCategory = "";		// ユーザーカテゴリ	

	public SecoStoreBeans() {}
	public SecoStoreBeans(
			//String LineNo,		// 通し番号
			String userID,		// アカウント名
			String pass,		// パスワード
			String userCategory, 	// ユーザーカテゴリ
			String userName,	// 店舗名／氏名
			String postCode,		// 郵便番号
			String area,		// 地域カテゴリ
			String address,		// 住所
			String phone,		// 電話番号
			String shopComment,	// 店舗コメント
			String mail)		// メールアドレス
	{
		//this.LineNo = LineNo;				// 通し番号		
		this.userID = userID;				// アカウント名
		this.pass = pass;					// パスワード
		this.userCategory = userCategory;	// ユーザーカテゴリ
		this.userName = userName;			// 店舗名／氏名
		this.postCode = postCode;			// 郵便番号
		this.area = area;					// 地域カテゴリ	
		this.address = address;				// 住所
		this.phone = phone;					// 電話番号
		this.shopComment = shopComment;		// 店舗コメント
		this.mail = mail;					// メールアドレス
	}

	public SecoStoreBeans(String userID, String pass) {	
		this.userID = userID;
		this.pass = pass;
	}

	//public String getSecoStoreLineNo() { return LineNo; }
	public String getSecoStoreuserID() { return userID; }
	public String getSecoStorepass()   { return pass; }
	public String getSecoStoreuserCategory() { return userCategory; }
	public String getSecoStoreuserName() { return userName; }
	public String getSecoStorepostCode() { return postCode; }
	public String getSecoStorearea()     { return area; }
	public String getSecoStoreaddress()  { return address; }
	public String getSecoStorephone()    { return phone; }
	public String getSecoStoreshopComment() { return shopComment; }
	public String getSecoStoremail()     { return mail; }

	//public void setSecoStoreLineNo() (int LineNo){this.LineNo = LineNo;}
	public void setSecoStoreuserID (String userID) {this.userID = userID;}
	public void setSecoStorepass   (String pass){this.pass=pass;}
	public void setSecoStoreuserCategory (String userCategory){this.userCategory = userCategory;}
	public void setSecoStoreuserName (String userName){this.userName=userName;}
	public void setSecoStorepostCode (String postCode){this.postCode=postCode;}
	public void setSecoStorearea     (String area){this.area= area;}
	public void setSecoStoreaddress  (String address){this.address=address;}
	public void setSecoStorephone    (String phone){this.phone=phone;}
	public void setSecoStoreshopComment (String shopComment){this.shopComment=shopComment;}
	public void setSecoStoremail     (String mail){this.mail=mail;}
	
}
