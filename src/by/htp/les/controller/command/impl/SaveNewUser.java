package by.htp.les.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.les.bean.User;
import by.htp.les.controller.command.Command;
import by.htp.les.service.ServiceException;
import by.htp.les.service.ServiceProvider;
import by.htp.les.service.UserService;
import by.htp.les.service.ValidatorService;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String login;
		String password;
		String name;
		String surname;

		login = request.getParameter("login");
		password = request.getParameter("password");
		name = request.getParameter("name");
		surname = request.getParameter("surname");

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserServise();
		ValidatorService validatorService = provider.getValidatorService();

		try {
			if (!validatorService.registrationValidator(request)) {
				response.sendRedirect("Controller?command=gotoindexpage&message = errorNew");
				return;
			}
			User user = new User(login, password, name, "user", surname);
			userService.registration(user);
			System.out.println(user.toString());
			if (user == null) {
				response.sendRedirect("Controller?command=gotomainpage&message=wrong2");
			}
			if (user != null) {

				HttpSession session = request.getSession(true);
				session.setAttribute("auth", true);
				session.setAttribute("role", user.getRole());
				session.setAttribute("message", "registration");
				response.sendRedirect("Controller?command=gotoindexpage");

			}
		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=gotoindexpage&message=wrongException");
		}

	}

}
