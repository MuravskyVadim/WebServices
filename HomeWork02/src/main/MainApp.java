package main;

import inteface.AccountService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

public class MainApp {
    public static void main(String[] args) throws Exception {
        AccountService service = new AccountServiceImpl();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignInServlet(service)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(service)), "/signup");

        ResourceHandler handler = new ResourceHandler();
        handler.setResourceBase("html");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[]{handler, context});

        Server server = new Server(6063);
        server.setHandler(handlerList);

        server.start();
        System.out.println("Server start successful!!!");
        server.join();
    }
}
