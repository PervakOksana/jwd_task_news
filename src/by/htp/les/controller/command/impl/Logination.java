package by.htp.les.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.les.bean.User;
import by.htp.les.controller.command.Command;
import by.htp.les.service.ServiceException;
import by.htp.les.service.ServiceProvider;
import by.htp.les.service.UserService;

public class Logination implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login;
		String password;

		login = request.getParameter("login");
		password = request.getParameter("password");

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserServise();
		HttpSession session = request.getSession();
		
		User user = null;

		try {
			user = userService.authorization(login, password);
			if (user == null) {
				
				session.setAttribute("messageLog", "errorLog");
				response.sendRedirect("Controller?command=gotoindexpage");
				

			} else {
				
				session.setAttribute("auth", true);
				session.setAttribute("role", user.getRole());
				session.setAttribute("message", user.getName());
				response.sendRedirect("Controller?command=gotomainpage");
			}
		} catch (ServiceException e) {

			response.sendRedirect("Controller?command=gotoindexpage&message=wrongException");
		}

	}

}
