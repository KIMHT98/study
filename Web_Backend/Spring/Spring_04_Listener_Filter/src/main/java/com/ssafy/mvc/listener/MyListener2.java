package com.ssafy.mvc.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


public class MyListener2 implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션이 시작될 때 호출2 ");
 
    	ServletContext context = sce.getServletContext();
    	System.out.println("welcome : "+context.getInitParameter("Welcome"));
    	
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션이 종료될 때 호출2");
    }
	
}
