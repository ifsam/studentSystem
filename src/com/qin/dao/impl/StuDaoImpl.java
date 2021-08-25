package com.qin.dao.impl;

import com.qin.dao.StuDao;
import com.qin.entity.Page;
import com.qin.entity.Student;
import com.qin.utils.MysqlUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;


public class StuDaoImpl implements StuDao {
    JdbcTemplate template = new JdbcTemplate(MysqlUtils.getDataSource());
    @Override
    public List<Student> queryAllStu() {
        String sql = "select * from student;";
        List<Student> studentList = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return studentList;
    }

    @Override
    public int addStu(Student student) {
        String sql = "insert into student (xuehao,stuName,sex,age,tel,qqEmail) values(?,?,?,?,?,?);";
        int i = template.update(sql, student.getXuehao(), student.getStuName(), student.getSex(), student.getAge(), student.getTel(), student.getQqEmail());
        return i;
    }

    @Override
    public int deleteStuById(String stuId) {
        String sql = "delete from student where id = ?;";
        int id = Integer.parseInt(stuId);
        return template.update(sql,id);
    }

    @Override
    public List<Student> queryStuBy(Student student, Page page) {
        StringBuilder sql = new StringBuilder("select * from student where 1 = 1");
        ArrayList<Object> params = new ArrayList<>();
        List<Student> studentList;
        if (student.getXuehao()!=null && !"".equals(student.getXuehao())){
            sql.append(" and xuehao = ?");
            params.add(student.getXuehao());
        }
        if (!"".equals(student.getStuName())&&student.getStuName()!=null){
            sql.append(" and stuName like ?");
            params.add("%"+student.getStuName()+"%");
        }
        if (!"".equals(student.getSex())&&student.getSex()!=null){
            sql.append(" and sex = ?");
            params.add(student.getSex());
        }
        if(page.getPages()>0&&(String.valueOf(page.getPages())!=null)&&!"".equals(page.getPages())){
            sql.append(" limit "+((page.getPages()-1)*page.getClums())+","+((page.getPages()-1)*page.getClums()+page.getClums()));
        }
        if(params.size()!=0){
            studentList = template.query(sql.toString(), new BeanPropertyRowMapper<Student>(Student.class), params.toArray());
            page.setCountClums(studentList.size());
        }else{
            studentList = template.query(sql.toString(), new BeanPropertyRowMapper<Student>(Student.class));
        }
        return studentList;
    }
}
