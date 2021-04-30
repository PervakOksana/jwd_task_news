package by.htp.les.controller.command.impl;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.les.bean.News;
import by.htp.les.controller.command.Command;
import by.htp.les.service.NewsService;
import by.htp.les.service.ServiceException;
import by.htp.les.service.ServiceProvider;
import by.htp.les.service.ValidatorService;

public class AddNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ServiceProvider provider = ServiceProvider.getInstance();
		ValidatorService validatorService = provider.getValidatorService();
		NewsService newsService = provider.getNewsService();
		HttpSession session = request.getSession();

		if (!validatorService.loginationValidator(request, response)) {
			response.sendRedirect("Controller?command=gotoindexpage");
			return;
		}
		try {
			if (!validatorService.dateValidator(request)) {
				session.setAttribute("notice", "error");
				RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/add_news.jsp");
				requestDispather.forward(request, response);

				return;
			}
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			String title = request.getParameter("title");
			String brief = request.getParameter("brief");
			String content = request.getParameter("content");
			String dateStr = request.getParameter("date");

			int active = 1;
			Date date = df.parse(dateStr);
			News news = new News(title, brief, content, date, active);		

			newsService.saveNew(news);
			response.sendRedirect("Controller?command=gotomainpage&message=");

		} catch (ParseException e) {
			
			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/error_page.jsp");
			requestDispather.forward(request, response);
		} catch (ServiceException e) {
			
			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/error_page.jsp");
			requestDispather.forward(request, response);

		}

	}

}
