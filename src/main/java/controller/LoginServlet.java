package controller;

import entity.User;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    private final TemplateEngine engine;
    private final LoginService service;

    public LoginServlet(TemplateEngine engine, LoginService service) {
        this.engine = engine;
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        engine.render("login.ftl", resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        User user = service.getUser(req.getParameter("email"), req.getParameter("psw"));
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("/users");
    }
}
