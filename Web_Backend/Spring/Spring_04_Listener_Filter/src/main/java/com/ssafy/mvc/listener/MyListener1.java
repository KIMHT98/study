package com.ssafy.mvc.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener1 implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션이 시작될 때 호출1 ");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션이 종료될 때 호출1");
    }
	
}
