package by.htp.les.service;



import java.util.List;

import by.htp.les.bean.News;

public interface NewsService {
	List <News> takeAll () throws ServiceException;
	boolean  saveChange (News news) throws ServiceException;
	boolean  saveNew (News news) throws ServiceException;
	boolean  delete (int id) throws ServiceException;

}
