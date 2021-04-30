package by.htp.les.dao;

import by.htp.les.dao.impl.SQLNewsDAO;
import by.htp.les.dao.impl.SQLUserDAO;

public final class DAOProvider {
	private static final DAOProvider instanse = new DAOProvider();
	private final UserDAO userdao = new SQLUserDAO();
	private final NewsDAO newsDAO = new SQLNewsDAO();
	
	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instanse;
	}
	
	public UserDAO getUserdao() {
		return userdao;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}
}
