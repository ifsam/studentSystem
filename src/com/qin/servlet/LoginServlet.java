package com.qin.servlet;

import com.qin.entity.User;
import com.qin.services.UserService;
import com.qin.services.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,map);
            UserService userService = new UserServiceImpl();
            List<User> users = userService.getUser(user.getUserName(), user.getPassWord());
            if (users!=null&&users.size()!=0){
                request.getSession().setAttribute("user",users.get(0));
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/erroServlet").forward(request,response);
                System.out.println("错误");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
