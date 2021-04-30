package by.htp.les.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les.controller.command.Command;
import by.htp.les.service.ServiceException;

public class GoToAddNewsPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try {
				RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/add_news.jsp");
				requestDispather.forward(request, response);
			} catch (ServletException e) {
				RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/error_page.jsp");
				requestDispather.forward(request, response);
			} catch (IOException e) {
				RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/jsp/error_page.jsp");
				requestDispather.forward(request, response);
			}

		
		
	}

}
