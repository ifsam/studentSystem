package com.qin.servlet;

import com.qin.entity.Page;
import com.qin.entity.Student;
import com.qin.services.StuService;
import com.qin.services.impl.StuServiceImpl;
import javafx.application.Application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllStuServlet")
public class ShowAllStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StuService stuService = new StuServiceImpl();
        List<Student> allStu = stuService.getAllStu();
        Page page = new Page();
        page.setCountClums(allStu.size());
        request.getSession().setAttribute("page", page);
        request.setAttribute("stulist", allStu);
        request.getRequestDispatcher("/html/showStu.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
