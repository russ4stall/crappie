package com.russ4stall.crappie;

import com.russ4stall.crappie.action.ActionInvoker;
import com.russ4stall.crappie.action.CrappieAction;
import com.russ4stall.crappie.action.CrappieParameterBinder;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.route.CrappieRouteMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.russ4stall.crappie.Crappie.*;

/**
 * @author Russ Forstall
 */

@WebServlet("/")
public class CrappieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        ServletContext servletContext = req.getServletContext();
        CrappieRouteMatcher routeMatcher = (CrappieRouteMatcher) servletContext.getAttribute(ROUTE_MATCHER);
        CrappieParameterBinder parameterBinder = (CrappieParameterBinder) servletContext.getAttribute(PARAMETER_BINDER);
        ActionInvoker actionInvoker = (ActionInvoker) servletContext.getAttribute(ACTION_INVOKER);
        Map<String, CrappieAction> actionManifest = (Map<String, CrappieAction>) servletContext.getAttribute(ACTION_MANIFEST);
        String uri = req.getRequestURI();

        CrappieAction action = routeMatcher.getAction(uri, actionManifest);

        //Let container handle errors
        if(action == null) {
            servletContext.getNamedDispatcher("default").forward(req, resp);
            return;
        }

        CrappieResult result = actionInvoker.getResult(action, parameterBinder, req, resp, servletContext);

        result.setRequest(req);
        result.setResponse(resp);

        result.handle();
    }


}
