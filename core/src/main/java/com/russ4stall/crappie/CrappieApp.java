package com.russ4stall.crappie;

import com.russ4stall.crappie.action.*;
import com.russ4stall.crappie.controller.CrappieControllerLocator;
import com.russ4stall.crappie.controller.CrappieControllerLocatorImpl;
import com.russ4stall.crappie.controller.Craptroller;
import com.russ4stall.crappie.route.CrappieRouteBuilder;
import com.russ4stall.crappie.route.CrappieRouteMatcher;
import com.russ4stall.crappie.route.NamingConventionRouteBuilder;
import com.russ4stall.crappie.route.NamingConventionRouteMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;
import java.util.Set;

import static com.russ4stall.crappie.Crappie.*;

/**
 * @author Russ Forstall
 *
 * User must extend this class in their base package
 */
public abstract class CrappieApp implements ServletContextListener {
    private CrappieControllerLocator controllerLocator = new CrappieControllerLocatorImpl();
    private CrappieRouteBuilder routeBuilder = new NamingConventionRouteBuilder();
    private CrappieRouteMatcher routeMatcher = new NamingConventionRouteMatcher();
    private CrappieParameterBinder parameterBinder = new ViewModelParameterBinder();
    private ActionInvoker actionInvoker = new ActionInvokerImpl();

    final public void contextInitialized(ServletContextEvent servletContextEvent) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        ServletContext servletContext = servletContextEvent.getServletContext();

        //User app set up
        //user given init instructions
        crappieInit(servletContext);

        Set<Craptroller> controllers = controllerLocator.findControllers(this.getClass());
        logger.info("CONTROLLERS: " + controllers.size() + " controller(s) were found using the " + controllerLocator.getClass().getSimpleName());

        Map<String, CrappieAction> actionManifest = routeBuilder.buildRoutes(controllers);
        logger.info("ROUTES: " + actionManifest.size() + " route(s) were found using the " + routeBuilder.getClass().getSimpleName());


        servletContext.setAttribute(PARAMETER_BINDER, parameterBinder);
        servletContext.setAttribute(ROUTE_MATCHER, routeMatcher);
        servletContext.setAttribute(ACTION_INVOKER, actionInvoker);
        servletContext.setAttribute(ACTION_MANIFEST, actionManifest);
    }

    public void crappieInit(ServletContext context) { crappieInit(); }

    public void crappieInit() { }

    public void contextDestroyed(ServletContextEvent servletContextEvent) { }

    final public void setControllerLocator(CrappieControllerLocator controllerLocator) {
        this.controllerLocator = controllerLocator;
    }

    final public void setRouteBuilder(CrappieRouteBuilder routeBuilder) {
        this.routeBuilder = routeBuilder;
    }

    final public void setRouteMatcher(CrappieRouteMatcher routeMatcher) {
        this.routeMatcher = routeMatcher;
    }

    public void setParameterBinder(CrappieParameterBinder parameterBinder) {
        this.parameterBinder = parameterBinder;
    }

    public void setActionInvoker(ActionInvoker actionInvoker) {
        this.actionInvoker = actionInvoker;
    }
}
