package by.htp.les.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp.les.bean.News;
import by.htp.les.dao.connection_pool.ConnectionPoolException;

public interface NewsDAO {

	List<News> all() throws DAOException;

	boolean saveChange(News news) throws DAOException;
	boolean saveNew(News news) throws  DAOException;
	boolean delete(int id) throws DAOException;
}
