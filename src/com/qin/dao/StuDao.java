package com.qin.dao;

import com.qin.entity.Page;
import com.qin.entity.Student;

import java.util.List;

public interface StuDao {
    List<Student> queryAllStu();
    int addStu(Student student);

    int deleteStuById(String stuId);
    List<Student> queryStuBy(Student student, Page page);
}
