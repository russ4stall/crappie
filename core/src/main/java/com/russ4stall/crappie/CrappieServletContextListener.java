package com.russ4stall.crappie;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Russ Forstall
 */
@WebListener
public class CrappieServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //TODO: make map of routes to class.method and place in ServletContext


    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
