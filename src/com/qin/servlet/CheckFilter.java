package com.qin.servlet;


import com.qin.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        if (uri.contains("/login.jsp")||uri.contains("/loginServlet")||
            uri.contains("/css/")||uri.contains("/js/")||uri.contains("/index.jsp")){
            filterChain.doFilter(req,res);
        }else{
            User user = (User) req.getSession().getAttribute("user");
            if (user!=null){
                filterChain.doFilter(req,res);
            }else{
                req.setAttribute("login_msg","您还没有登录，请登录！");
                req.getRequestDispatcher("/html/login.jsp").forward(req,res);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
