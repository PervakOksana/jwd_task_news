package by.htp.les.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.les.bean.News;
import by.htp.les.dao.DAOException;
import by.htp.les.dao.NewsDAO;
import by.htp.les.dao.connection_pool.ConnectionPool;
import by.htp.les.dao.connection_pool.ConnectionPoolException;
import by.htp.les.dao.connection_pool.ConnectionProvider;

public class SQLNewsDAO implements NewsDAO {

	static {
		MYSQLDriverLoader.getInstance();
	}

	Statement st = null;
	ConnectionProvider provider = ConnectionProvider.getInstance();
	ConnectionPool cp = provider.getConnectionPool();

	@Override
	public List<News> all() throws DAOException {
		final String LIST_NEWS = "SELECT * FROM news";
		ResultSet rs = null;
		List<News> news = null;
		Connection con = null;
		try {
			cp.initPoolData();
			con = cp.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(LIST_NEWS);

			news = new ArrayList<News>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				Date data = rs.getDate("data");
				int active = rs.getInt("active");

				News n = new News(id, title, brief, content, data, active);
				if (active == 1) {
					news.add(n);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (NullPointerException e) {
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			} catch (NullPointerException e) {
				throw new DAOException(e);
			}
		}

		return news;
	}

	@Override
	public boolean saveChange(News news) throws DAOException {
		System.out.println("SQLNewsDAO metod saveChange   " + news.toString());
		Connection con = null;
		boolean result = true;
		final String NEWS_UPDATE = "UPDATE news SET title=?, brief=?, content =? WHERE id=?";

		try {
			cp.initPoolData();
			con = cp.takeConnection();
			PreparedStatement preparedStatement = con.prepareStatement(NEWS_UPDATE);

			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getBrief());
			preparedStatement.setString(3, news.getContent());
			preparedStatement.setInt(4, news.getId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			result = false;
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return result;
	}

	@Override
	public boolean delete(int id) throws DAOException {
		Connection con = null;
		boolean result = true;
		try {
			cp.initPoolData();
			con = cp.takeConnection();
			st = con.createStatement();
			String command = "UPDATE news SET active ='0' WHERE id=" + id;
			st.executeUpdate(command);

		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return result;

	}

	@Override
	public boolean saveNew(News news) throws DAOException {
		Connection con = null;
		boolean result = true;
		final String NEWS_ADD = "INSERT INTO news (title, brief, content,data,active) VALUES (?,?,?,?,?)";
		try {
			cp.initPoolData();
			con = cp.takeConnection();
			PreparedStatement preparedStatement = con.prepareStatement(NEWS_ADD);

			java.sql.Date sqlDate = new java.sql.Date(news.getData().getTime());
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getBrief());
			preparedStatement.setString(3, news.getContent());
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setString(5, "1");

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			result = false;
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {

			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return result;
	}

}
