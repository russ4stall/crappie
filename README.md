# Crappie

####Pronounced \ˈkrä-pē\

Crappie is a simple MVC web framework built on the Servlet API. It's designed to be completely hackable offering interfaces for almost every area of functionality.

## QUICK START
To use crappie framework, create a class that extends CrappieApp and annotate it with `javax.servlet.annotation.WebListener`.

```
import com.russ4stall.crappie.CrappieApp;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyApp extends CrappieApp {
    @Override
    public void crappieInit(ServletContext context) {
        //Startup tasks go here...
    }
}
```

Create a class that extends CrappieController and write a public method that returns a CrappieResult.

```
import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.JSP;

public class Home extends CrappieController {

    public CrappieResult index() {

        return new Raw("Hello Wuurld");
    }
}
```

Deploy to an application server and navigate to `http://localhost:8080/home`


Now have a hardly deserved beer because you just made a crappie web app!

## IN DETAIL
Crappie offers interfaces for nearly every aspect of it's operations.
- **ControllerLocator** : Determines how controller classes are identified.
- **RouteBuilder** : Specifies how routes are built. (Default implementation is naming convention).
- **RouteMatcher** : Specifies how requests are matched to action methods. (*This should obviously match the RouteBuilder*)
- **ParameterBinder** : Specifies how request parameters are passed into the action methods. (Default implementation uses view-models with primitive types)
- **ActionInvoker** : This is how action methods are executed. (This is where the magic happens and unfortunately is where the API is the least loosely coupled.) 
- **Result** : This handles the view portion of the framework.

All of the above Classes can be implemented for custom behavior.
