package com.qin.servlet;

import com.qin.entity.Student;
import com.qin.entity.User;
import com.qin.services.StuService;
import com.qin.services.impl.StuServiceImpl;
import javafx.scene.control.Alert;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            Map<String, String[]> map = request.getParameterMap();
            Student student = new Student();
            BeanUtils.populate(student,map);
            StuService stuService = new StuServiceImpl();
            int i = stuService.addStu(student);
            if (i!=0){
                request.getRequestDispatcher("/showAllStuServlet").forward(request,response);
            }else {
                request.getRequestDispatcher("/erroServlet").forward(request,response);
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
