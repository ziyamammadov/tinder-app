package filter;

import controller.TemplateEngine;
import service.LoginService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LoginFilter implements Filter {private final TemplateEngine engine;
    private final LoginService service;

    public LoginFilter(TemplateEngine engine, LoginService service) {
        this.engine = engine;
        this.service = service;
    }
    @Override
    public void init(FilterConfig filterConfig){

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest)servletRequest).getMethod().equals("POST")) {
            HashMap<String, Object> data = new HashMap<>();
            String email = servletRequest.getParameter("email");
            String password = servletRequest.getParameter("psw");
            if (service.isUserValid(email, password)) {
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                data.put("message", "<label class=\"error\">Wrong password or email!</label>\n");
                engine.render("login.ftl", data, (HttpServletResponse) servletResponse);}
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
