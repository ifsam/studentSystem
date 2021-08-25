package com.qin.entity;

public class Student {
    private int id;
    private String xuehao;
    private String stuName;
    private String age;
    private String sex;
    private String tel;
    private String qqEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQqEmail() {
        return qqEmail;
    }

    public void setQqEmail(String qqEmail) {
        this.qqEmail = qqEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", xuehao='" + xuehao + '\'' +
                ", stuName='" + stuName + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", qqEmail='" + qqEmail + '\'' +
                '}';
    }
}
