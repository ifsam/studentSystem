package com.qin.services.impl;

import com.qin.dao.impl.StuDaoImpl;
import com.qin.entity.Page;
import com.qin.entity.Student;
import com.qin.services.StuService;

import java.util.List;

public class StuServiceImpl implements StuService {
    StuDaoImpl stuDao = new StuDaoImpl();
    @Override
    public List<Student> getAllStu() {
        List<Student> studentList = stuDao.queryAllStu();
        return studentList;
    }

    @Override
    public int addStu(Student student) {
        return stuDao.addStu(student);
    }

    @Override
    public int deleteStuById(String stuId) {
        return stuDao.deleteStuById(stuId);
    }

    @Override
    public List<Student> queryStuBy(Student student, Page page) {
        System.out.println(222);
        return stuDao.queryStuBy(student,page);
    }
}
