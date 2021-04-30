package by.htp.les.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.les.service.ValidatorService;

public class ValidatorServiceImpl implements ValidatorService {

	@Override
	public boolean loginationValidator(HttpServletRequest request, HttpServletResponse response) {
		boolean result = true;
		HttpSession session = request.getSession();
		if (session == null) {
			result = false;

		}
		Boolean iaAuth = (Boolean) session.getAttribute("auth");
		if (iaAuth == null || !iaAuth) {
			result = false;

		}
		return result;
	}

	@Override
	public boolean registrationValidator(HttpServletRequest request) {
		String password;

		password = request.getParameter("password");

		Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}");
		Matcher matcher = pattern.matcher(password);
		matcher.lookingAt();
		return matcher.lookingAt();
	}

	@Override
	public boolean dateValidator(HttpServletRequest request) {
		String date;

		date = request.getParameter("date");

		Pattern pattern = Pattern.compile("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
		Matcher matcher = pattern.matcher(date);
		matcher.lookingAt();
		return matcher.lookingAt();
	}

}
