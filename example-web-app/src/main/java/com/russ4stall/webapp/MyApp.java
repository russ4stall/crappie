package com.russ4stall.webapp;

import com.russ4stall.crappie.CrappieApp;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

/**
 * @author Russ Forstall
 */
@WebListener
public class MyApp extends CrappieApp {
    @Override
    public void crappieInit(ServletContext context) {
        //Startup tasks go here...
    }
}
