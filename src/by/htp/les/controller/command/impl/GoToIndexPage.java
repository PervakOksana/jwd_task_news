package by.htp.les.controller.command.impl;

import java.io.IOException;
import java.util.List;

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

public class GoToIndexPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		HttpSession session = request.getSession();
		try {
			List<News> news = newsService.takeAll();

			request.setAttribute("news", news);

			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
			requestDispather.forward(request, response);
			session.removeAttribute("messageLog");
			session.removeAttribute("message");

		} catch (ServiceException e) {
			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/error_page.jsp");
			requestDispather.forward(request, response);
		}

	}

}
