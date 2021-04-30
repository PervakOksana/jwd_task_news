package by.htp.les.service;

import by.htp.les.service.impl.NewsServiceImpl;
import by.htp.les.service.impl.UserServiceImpl;
import by.htp.les.service.impl.ValidatorServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private ServiceProvider() {
	}

	private final UserService userServise = new UserServiceImpl();
	private final NewsService newsService = new NewsServiceImpl();
	private final ValidatorService validatorService = new ValidatorServiceImpl();

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserServise() {
		return userServise;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public ValidatorService getValidatorService() {
		return validatorService;
	}

}
