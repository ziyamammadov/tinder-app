package controller;

import entity.Dislike;
import entity.Like;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class UserServlet extends HttpServlet {
    private final TemplateEngine engine;
    private final UserService service;

    public UserServlet(TemplateEngine engine, UserService service) {
        this.engine = engine;
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (service.getUserToDisplay(user) != null) {
            User selected = service.getUserToDisplay(user);
            data.put("image_url", selected.getPictureUrl());
            data.put("name", selected.getName());
            engine.render("like-page.ftl", data, resp);
        } else {
            resp.sendRedirect("/liked");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        String button = req.getParameter("button");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        User selected = service.getUserToDisplay(user);
        if (button.equals("dislike") && selected != null) {
            service.addDislike(new Dislike(user.getId(), selected.getId()));
        } else if (button.equals("like") && selected != null) {
            service.addLike(new Like(user.getId(), selected.getId()));
        } else {
            resp.sendRedirect("/liked");
        }
        data.put("image_url", selected.getPictureUrl());
        data.put("name", selected.getName());
        engine.render("like-page.ftl", data, resp);
    }
}
