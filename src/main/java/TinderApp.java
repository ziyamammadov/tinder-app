import controller.*;
import dao.DAODislike;
import dao.DAOLike;
import dao.DAOMessage;
import dao.DAOUser;
import filter.MessageFilter;
import filter.SessionFilter;
import filter.LoginFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.*;

import javax.servlet.DispatcherType;
import java.util.EnumSet;


public class TinderApp {
    public static void main(String[] args) throws Exception {
        TemplateEngine engine = TemplateEngine.resources("/templates");
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        DAOUser daoUser = new DAOUser();
        DAOLike daoLike = new DAOLike();
        DAODislike daoDislike = new DAODislike();
        DAOMessage daoMessage = new DAOMessage();
        LoginService loginService = new LoginService(daoUser);
        UserService userService = new UserService(daoUser,daoLike,daoDislike);
        LikeService likeService= new LikeService(daoUser);
        MessageService messageService = new MessageService(daoMessage);
//        ---------------------------------------------------------------------
        handler.addServlet((new ServletHolder(new StaticContentServlet("src/main/resources/templates"))), "/static/*");
        handler.addFilter(new FilterHolder(new LoginFilter(engine,loginService)), "/login/*", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(SessionFilter.class, "/liked", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(SessionFilter.class, "/messages/{id}", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(SessionFilter.class, "/users", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(MessageFilter.class, "/messages/{id}", EnumSet.of(DispatcherType.REQUEST));

        handler.addServlet((new ServletHolder(new LoginServlet(engine,loginService))), "/login");
        handler.addServlet((new ServletHolder(new RegistrationServlet(engine,new RegisterService(daoUser)))), "/register");
        handler.addServlet((new ServletHolder(new LikeServlet(engine,likeService))), "/liked");
        handler.addServlet((new ServletHolder(new MessageServlet(engine,messageService))), "/messages/*");
        handler.addServlet((new ServletHolder(new UserServlet(engine,userService))), "/users");
        handler.addServlet(ErrorServlet.class, "/*");
//        ----------------------------------------------------------------------

        Server server = new Server(5000);
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
