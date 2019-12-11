package controller;

import entity.Message;
import entity.User;
import service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MessageServlet extends HttpServlet {
    private final TemplateEngine engine;
    private final MessageService service;

    public MessageServlet(TemplateEngine engine, MessageService service) {
        this.engine = engine;
        this.service=service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        engine.render("chat.ftl",resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String path = req.getPathInfo();
        String message = req.getParameter("message");
        System.out.println(path);
//        service.addMessage(new Message(user.getId(),Integer.parseInt(path),message));
    }
}
