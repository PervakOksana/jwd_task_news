package by.htp.les.controller.command.impl;

import java.io.IOException;

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

public class SaveNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		ValidatorService validatorService = provider.getValidatorService();

		if (!validatorService.loginationValidator(request, response)) {
			response.sendRedirect("Controller?command=gotoindexpage");
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));

		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");

		News news = new News(id, title, brief, content);
		String massege = "Don't save";

		try {
			boolean result = newsService.saveChange(news);
			if (result)
				massege = "Save OK";

		} catch (ServiceException e) {
			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/error_page.jsp");
			requestDispather.forward(request, response);
		}

		response.sendRedirect("Controller?command=gotomainpage&message=");

	}

}
