package by.htp.les.dao;

import by.htp.les.bean.RegistrationInfo;
import by.htp.les.bean.User;

public interface UserDAO {
	User authorization(String login, String password) throws DAOException;
	boolean registration (User user) throws DAOException;
}
