package com.hero.service;

import com.hero.pojo.Student;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-30-15:18
 * @Description:
 */
public interface StudentService {

    //    添加学生
    void insert(Student student);

    //    删除学生
    void delete(int stuId);

    //    修改学生信息
    void update(Student student);

    //    查询一个学生的信息
    Student query(int stuId);

    //    查询所有学生信息
    List<Student> queryAll();

    //    查询所有学生信息 —— 分页查询
    List<Student> queryAllPages(int start,int count);

    //    查询学生个数
    int queryNum();

}
