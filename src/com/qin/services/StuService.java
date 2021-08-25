package com.qin.services;

import com.qin.entity.Page;
import com.qin.entity.Student;

import java.util.List;

public interface StuService {
    List<Student> getAllStu();
    int addStu(Student student);

    int deleteStuById(String stuId);

    List<Student> queryStuBy(Student student, Page page);
}
