
package model;

import java.io.Serializable;

public class SecoBookBeans implements Serializable {
	int bookNo;
	String Msg;
	private int user_bookNo;
	private String user_Msg;
	
	/*
	public SecoBookBeans(
			int User_bookNo,
			String User_Msg) {
		this.user_bookNo = bookNo;
		this.user_Msg = Msg;
	}
	*/
	
	//予約番号のゲッター/セッタを作成
	public int getUser_bookNo(){
		return user_bookNo;
		}
	public void setUser_bookNo(int bookNo){		
		this.user_bookNo=bookNo;}
		
		//Msgのゲッター/セッタを作成
		public String getUser_Msg(){
			return user_Msg;
			}
		public void setUser_Msg(String Msg){		
			this.user_Msg=Msg;
}
}
