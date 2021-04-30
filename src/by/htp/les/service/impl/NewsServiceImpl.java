package by.htp.les.service.impl;

import java.util.List;

import by.htp.les.bean.News;
import by.htp.les.dao.DAOException;
import by.htp.les.dao.DAOProvider;
import by.htp.les.dao.NewsDAO;
import by.htp.les.service.NewsService;
import by.htp.les.service.ServiceException;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> takeAll() throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();

		List<News> news = null;

		try {
			news = newsDAO.all();

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return news;
	}

	@Override
	public boolean saveChange(News news) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		boolean result = false;

		try {
			newsDAO.saveChange(news);
			result = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean delete(int id) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		boolean result = false;

		try {
			newsDAO.delete(id);
			result = true;
		} catch (DAOException e) {

			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean saveNew(News news) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		boolean result = false;

		try {
			newsDAO.saveNew(news);

			result = true;
		} catch (DAOException e) {

			throw new ServiceException(e);
		}
		return result;
	}

}
