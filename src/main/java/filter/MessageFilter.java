package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig){

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String pathInfo = req.getPathInfo();
        try{
            Integer.parseInt(pathInfo.substring(1));
            filterChain.doFilter(servletRequest, servletResponse);
        }catch (NumberFormatException e){
            resp.sendRedirect("/liked");
        }
    }

    @Override
    public void destroy() {

    }
}
