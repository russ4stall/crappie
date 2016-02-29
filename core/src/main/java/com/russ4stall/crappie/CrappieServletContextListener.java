package com.russ4stall.crappie;

import com.russ4stall.crappie.controller.CrappieControllerLocator;
import com.russ4stall.crappie.controller.NamingConventionControllerLocator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Set;

/**
 * @author Russ Forstall
 *
 * User must extend this class to have crappie work correctly.
 */
public abstract class CrappieServletContextListener implements ServletContextListener {
    final public void contextInitialized(ServletContextEvent servletContextEvent) {
        crappieInit(servletContextEvent.getServletContext());

        CrappieControllerLocator locator = new NamingConventionControllerLocator();
        Set<Class<?>> controllers = locator.findControllers(this.getClass());

        for (Class<?> clazz : controllers){
            System.out.println(clazz.getCanonicalName());
        }

        System.out.println("test");
    }

    public void crappieInit(ServletContext context) { crappieInit(); }

    public void crappieInit() { }

    public void contextDestroyed(ServletContextEvent servletContextEvent) { }
}
