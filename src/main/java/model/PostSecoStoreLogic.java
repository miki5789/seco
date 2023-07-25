package model;

import dao.SecoStoreDAO;

public class PostSecoStoreLogic {
	public void execute(SecoStoreBeans secoStoreB) {
		SecoStoreDAO dao = new SecoStoreDAO();
		dao.create(secoStoreB);
	}
}