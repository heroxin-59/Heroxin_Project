package com.hero.service.impl;

import com.hero.mapper.StudentMapper;
import com.hero.pojo.Student;
import com.hero.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-30-15:20
 * @Description:
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false,propagation = Propagation.REQUIRED)
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false,propagation = Propagation.REQUIRED)
    public void delete(int stuId) {
        studentMapper.delete(stuId);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false,propagation = Propagation.REQUIRED)
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public Student query(int stuId) {
        return studentMapper.query(stuId);
    }

    @Override
    public List<Student> queryAll() {
        return studentMapper.queryAll();
    }

    @Override
    public List<Student> queryAllPages(int start,int count) {
        return studentMapper.queryAllPages(start,count);
    }

    @Override
    public int queryNum() {
        return studentMapper.queryNum();
    }

}
