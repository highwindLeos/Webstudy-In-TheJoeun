package com.tj.ex2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerEx implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("웹 애플리케이션 종료 : 프로젝트가 닫혔습니다.");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("웹 애플리케이션 시작 : 프로젝트가 열렸습니다.");
	}

}
