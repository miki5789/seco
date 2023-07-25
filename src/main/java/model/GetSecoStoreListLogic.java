package model;

import java.util.List;

import dao.SecoStoreDAO;

public class GetSecoStoreListLogic {
	public List<SecoStoreBeans> execute() {
		SecoStoreDAO dao = new SecoStoreDAO();
		List<SecoStoreBeans> secoStoreBList = dao.findAll();
		return secoStoreBList;
	}

}
