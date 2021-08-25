package com.qin.servlet;

import com.qin.services.StuService;
import com.qin.services.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStu")
public class DeleteStu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuId = request.getParameter("stuId");
        StuService stuService = new StuServiceImpl();
        int i = stuService.deleteStuById(stuId);
        if (i!=0){
            request.getRequestDispatcher("/showAllStuServlet").forward(request,response);
        }else {
            request.getRequestDispatcher("/html/erroPage.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
