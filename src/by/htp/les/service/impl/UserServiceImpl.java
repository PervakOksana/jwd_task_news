package by.htp.les.service.impl;

import by.htp.les.bean.RegistrationInfo;
import by.htp.les.bean.User;
import by.htp.les.dao.DAOException;
import by.htp.les.dao.DAOProvider;
import by.htp.les.dao.UserDAO;
import by.htp.les.dao.impl.SQLUserDAO;
import by.htp.les.service.ServiceException;
import by.htp.les.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String login, String password) throws ServiceException {
		// validation
		if (login == null || "".equals(login)) {
			throw new ServiceException("Wrong login or password");
		}
		DAOProvider proviger = DAOProvider.getInstance();
		UserDAO userDAO = proviger.getUserdao();

		User user = null;
		try {
			user = userDAO.authorization(login, password);
			
		} catch (DAOException e) {
			throw new ServiceException( e);
		}

		return user;
	}
	@Override
	public boolean registration(User user) throws ServiceException {

		DAOProvider proviger = DAOProvider.getInstance();
		UserDAO userDAO = proviger.getUserdao();
		boolean result = false;
		try {
			result = userDAO.registration(user);
			
		} catch (DAOException e) {
			throw new ServiceException( e);
		}
		return result;
	}

}
