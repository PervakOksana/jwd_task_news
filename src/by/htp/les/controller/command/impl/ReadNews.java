package by.htp.les.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.les.bean.News;
import by.htp.les.controller.command.Command;
import by.htp.les.service.NewsService;
import by.htp.les.service.ServiceException;
import by.htp.les.service.ServiceProvider;
import by.htp.les.service.ValidatorService;

public class ReadNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		ValidatorService validatorService = provider.getValidatorService();

		if (!validatorService.loginationValidator(request, response)) {
			response.sendRedirect("Controller?command=gotoindexpage");
			return;
		}

		int id = Integer.parseInt(request.getParameter("link_id"));
		try {
			List<News> news = newsService.takeAll();

			for (News n : news) {
				if (n.getId() == id) {

					request.setAttribute("news", n);

				}
			}

			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/read_news.jsp");
			requestDispather.forward(request, response);

		} catch (ServiceException e) {
			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/error_page.jsp");
			requestDispather.forward(request, response);
		}

	}

}
