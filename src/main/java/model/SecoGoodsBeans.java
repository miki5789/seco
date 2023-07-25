package model;

import java.io.Serializable;

public class SecoGoodsBeans implements Serializable {
	//private int itemID = 0;
	private String userID = "";
	private String itemName = "";
	private String itemCategory = "";
	private int price = 0;
	private int stock = 0;
	private String itemTitle = "";
	private String itemComment = "";
	private String image = "";
	private int leftDays = 1;
	private String endDate = "";

	public SecoGoodsBeans() {}
	public SecoGoodsBeans(
			//int itemID,
			String userID,
			String itemName,
			String itemCategory,
			int price,
			int stock,
			String itemTitle,
			String itemComment,
			String image,
			int leftDays,
			String endDate){
		this.userID = userID;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.price = price;
		this.stock = stock;
		this.itemTitle = itemTitle;
		this.itemComment = itemComment;
		this.image = image;
		this.leftDays = leftDays;
		this.endDate = endDate;
	}

	//public int getSecoGoodsitemID()   { return itemID; }
	//public void setSecoGoodsitemID(int itemID){this.itemID=itemID;}
	public String getSecoGoodsuserID() { return userID; }
	public void setSecoGoodsuserID(String userID){this.userID=userID;}
	public String getSecoGoodsitemName() { return itemName; }
	public void setSecoGoodsitemName(String itemName) {this.itemName=itemName;}
	public String getSecoGoodsitemCategory() { return itemCategory; }
	public void setSecoGoodsitemCategory(String itemCategory){this.itemCategory=itemCategory;}
	public int getSecoGoodsprice() { return price; }
	public void setSecoGoodsprice(int price){this.price=price;}
	public int getSecoGoodsstock()     { return stock; }
	public void setSecoGoodsstock(int stock){this.stock=stock;}
	public String getSecoGoodsitemTitle()  { return itemTitle; }
	public String getSecoGoodsitemComment()    { return itemComment; }
	public void setSecoGoodsitemComment(String itemComment){this.itemComment=itemComment;}
	public String getSecoGoodsimage() { return image; }
	public void setSecoGoodsimage(String image){this.image=image;}
	public int getSecoGoodsleftDays()     { return leftDays; }
	public void setSecoGoodsleftDays(int leftDays){this.leftDays=leftDays;}
	public String getSecoGoodsendDate()     { return endDate; }
	public void setSecoGoodsendDate(String endDate){this.endDate=endDate;}
	}
