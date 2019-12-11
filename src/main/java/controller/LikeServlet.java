package controller;

import entity.User;
import service.LikeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LikeServlet extends HttpServlet {
    private final TemplateEngine engine;
    private final LikeService service;

    public LikeServlet(TemplateEngine engine, LikeService service) {
        this.engine = engine;
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<User> likedUsers = service.getLikedUsers(user.getId());
        data.put("users", likedUsers);
        engine.render("people-list.ftl", data, resp);
    }
}
