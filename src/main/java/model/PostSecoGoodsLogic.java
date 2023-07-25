package model;

import dao.SecoGoodsDAO;

public class PostSecoGoodsLogic {
	public void execute(SecoGoodsBeans secoGoodsB) {
		SecoGoodsDAO dao = new SecoGoodsDAO();
		dao.create(secoGoodsB);
	}
}