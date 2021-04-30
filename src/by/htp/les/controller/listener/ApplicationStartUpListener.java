package by.htp.les.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp.les.dao.connection_pool.ConnectionProvider;

public class ApplicationStartUpListener implements ServletContextListener {

	ConnectionProvider provider = ConnectionProvider.getInstance();

	@Override
	public void contextInitialized(ServletContextEvent event) {
		provider.initConnectionPool();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		provider.disposeConnectionPool();
	}
}