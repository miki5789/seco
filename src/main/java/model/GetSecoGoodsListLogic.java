package model;

import java.util.List;

import dao.SecoGoodsDAO;

public class GetSecoGoodsListLogic {
	public List<SecoGoodsBeans> execute() {
		SecoGoodsDAO dao = new SecoGoodsDAO();
		List<SecoGoodsBeans> secoGoodsBList = dao.findAll();
		return secoGoodsBList;
	}
}
