package by.htp.les.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les.controller.command.Command;

public class Localization implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String language = request.getParameter("lang");
		String command = request.getParameter("page"); 
		String link_id = request.getParameter("link_id"); 
		String commandAll = command+"&link_id="+link_id;
		
		request.getSession(true).setAttribute("local", language);
		response.sendRedirect("Controller?command=" + commandAll);
		
	}

}
