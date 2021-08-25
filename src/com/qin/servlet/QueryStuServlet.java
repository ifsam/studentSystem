package com.qin.servlet;

import com.qin.entity.Page;
import com.qin.entity.Student;
import com.qin.entity.User;
import com.qin.services.impl.StuServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/queryStuServlet")
public class QueryStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Student student = new Student();
        Page page = (Page) request.getSession().getAttribute("page");
        try {
            BeanUtils.populate(student,map);
            BeanUtils.populate(page,map);
            StuServiceImpl stuService = new StuServiceImpl();
            List<Student> students = stuService.queryStuBy(student,page);
            if (students!=null){
                request.setAttribute("stulist",students);
                request.setAttribute("stu",student);
                request.getRequestDispatcher("/html/showStu.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/html/erro.jsp").forward(request,response);
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
