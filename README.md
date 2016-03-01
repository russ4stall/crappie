# crappie
Crappie is a simple web framework built on the Servlet API.

The goal of this project is for me to learn more about Java, Servlets, and web development in general.

## QUICK START
To use crappie framework, create a class that extends CrappieApp and annotate it with `javax.servlet.annotation.WebListener`.

```
@WebListener
public class MyApp extends CrappieApp {
    @Override
    public void crappieInit(ServletContext context) {
        //Startup tasks go here...
    }
}
```


