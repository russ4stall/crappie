package com.russ4stall.crappie.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by russellf on 3/1/2016.
 */
public class StaticResourcesFilter implements Filter {

    private RequestDispatcher defaultRequestDispatcher;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.defaultRequestDispatcher = filterConfig.getServletContext().getNamedDispatcher("default");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        defaultRequestDispatcher.forward(request, response);
    }

    @Override
    public void destroy() {}
}
