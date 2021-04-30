package by.htp.les.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import by.htp.les.bean.User;
import by.htp.les.dao.DAOException;
import by.htp.les.dao.UserDAO;
import by.htp.les.dao.connection_pool.ConnectionPool;
import by.htp.les.dao.connection_pool.ConnectionPoolException;
import by.htp.les.dao.connection_pool.ConnectionProvider;

public class SQLUserDAO implements UserDAO {
	static {
		MYSQLDriverLoader.getInstance();
	}

	Connection con = null;
	Statement st = null;
	ConnectionProvider provider = ConnectionProvider.getInstance();
	ConnectionPool cp = provider.getConnectionPool();

	@Override
	public User authorization(String login, String password) throws DAOException {

		ResultSet rs = null;
		User user = null;

		try {
			cp.initPoolData();
			con = cp.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM users WHERE login = '" + login + "' AND password ='" + password + "'");

			while (rs.next()) {

				login = rs.getString("login");
				password = rs.getString("password");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String role = rs.getString("role");

				user = new User(login, password, surname, role, name);

			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (NullPointerException e) {
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			} catch (NullPointerException e) {
				throw new DAOException(e);
			}
		}

		return user;
	}

	@Override
	public boolean registration(User user) throws DAOException {

		boolean result = true;

		try {
			cp.initPoolData();
			con = cp.takeConnection();
			st = con.createStatement();

			String command = "INSERT INTO users (login, password,name ,surname, role) VALUES ('" + user.getLogin()
					+ "','" + user.getPassword() + "','" + user.getName() + "','" + user.getSurname() + "','"
					+ user.getRole() + "')";
			st.executeUpdate(command);

		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return result;
	}

}
