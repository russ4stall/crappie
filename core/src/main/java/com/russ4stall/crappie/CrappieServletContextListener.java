package com.russ4stall.crappie;

import org.reflections.Reflections;

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

        //TODO: make map of routes to class.method and place in ServletContext

        //TODO search package for controllers
        Reflections reflections = new Reflections(this.getClass().getPackage());
        Set<Class<?>> annotatedControllers = reflections.getTypesAnnotatedWith(Controller.class);

        for (Class c : annotatedControllers) {
            System.out.println(c.getCanonicalName());
        }

    }

    public void crappieInit(ServletContext context) { crappieInit(); }

    public void crappieInit() { }

    public void contextDestroyed(ServletContextEvent servletContextEvent) { }
}
