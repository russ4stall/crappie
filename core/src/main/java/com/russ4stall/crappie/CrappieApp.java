package com.russ4stall.crappie;

import com.russ4stall.crappie.action.CrappieAction;
import com.russ4stall.crappie.controller.CrappieControllerLocator;
import com.russ4stall.crappie.controller.CrappieControllerLocatorImpl;
import com.russ4stall.crappie.controller.Craptroller;
import com.russ4stall.crappie.route.CrappieRouteBuilder;
import com.russ4stall.crappie.route.NamingConventionRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 *
 * User must extend this class in their base package
 */
public abstract class CrappieApp implements ServletContextListener {
    private String staticResourcesPath = "/public";

    final public void contextInitialized(ServletContextEvent servletContextEvent) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        ServletContext servletContext = servletContextEvent.getServletContext();

        //User app set up
        //user given init instructions
        crappieInit(servletContext);


        CrappieControllerLocator locator = new CrappieControllerLocatorImpl();
        Set<Craptroller> controllers = locator.findControllers(this.getClass());

        logger.info("CONTROLLERS: Crappie found " + controllers.size() + " controller(s) using the "
                + locator.getClass().getSimpleName());

        CrappieRouteBuilder routeBuilder = new NamingConventionRouteBuilder();
        Map<String, CrappieAction> actionManifest = routeBuilder.buildRoutes(controllers);

        logger.info("ROUTES: Crappie found " + actionManifest.size() + " route(s) using the "
                + routeBuilder.getClass().getSimpleName());

        servletContextEvent.getServletContext().setAttribute("actionManifest", actionManifest);
    }

    public void crappieInit(ServletContext context) { crappieInit(); }

    public void crappieInit() { }

    public void contextDestroyed(ServletContextEvent servletContextEvent) { }

    final public void setStaticResourcesPath(String staticResourcesPath) {
        this.staticResourcesPath = staticResourcesPath;
    }
}
