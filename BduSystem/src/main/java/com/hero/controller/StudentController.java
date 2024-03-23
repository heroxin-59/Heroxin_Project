package com.hero.controller;

import com.hero.pojo.Student;
import com.hero.service.StudentService;
import com.hero.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-30-15:23
 * @Description:
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ModelAndView modelAndView;

//    查询所有学生信息
/*    @RequestMapping("/queryAll")
    public ModelAndView queryAll(){
        List<Student> studentList = studentService.queryAll();

        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("student-list");

        return modelAndView;
    }*/

//    查询所有学生的信息——分页查询
    @RequestMapping("/queryAllPage")
    public ModelAndView queryAllPage(HttpServletRequest request){

        int start = 0;
        int count = 7;
        try {
            start = Integer.parseInt(request.getParameter("page.start"));
            count = Integer.parseInt(request.getParameter("page.count"));
        }catch (Exception e){
        }

        Page page = new Page(start,count);

        List<Student> studentList = studentService.queryAllPages(page.getStart(), page.getCount());
        int total = studentService.queryNum();
        page.setTotal(total);


        modelAndView.addObject("page",page);
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("student-list-page");

        return modelAndView;
    }

//    查询一个学生信息
    @RequestMapping("/queryOne")
    public ModelAndView queryOne(int stuId){
        Student query = studentService.query(stuId);

        modelAndView.addObject("query",query);
        modelAndView.setViewName("student-search");

        return modelAndView;
    }

//    跳转到添加学生页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "student-add";
    }

//    添加学生请求
    @RequestMapping("/insert")
    public String insert(Student student){
        studentService.insert(student);

        return "redirect:/student/queryAllPage";
    }

//    跳转到更改学生信息页面
    @RequestMapping("/toUpdate/{stuId}")
    public ModelAndView toUpdate(@PathVariable("stuId") int stuId){
        Student query = studentService.query(stuId);

        modelAndView.addObject("query",query);
        modelAndView.setViewName("student-update");

        return modelAndView;
    }

//    更改学生信息请求
    @RequestMapping("/update")
    public String update(Student student){
        studentService.update(student);

        return "redirect:/student/queryAllPage";
    }

//    删除学生信息请求
    @RequestMapping("/delete/{stuId}")
    public String delete(@PathVariable("stuId") int stuId){
        studentService.delete(stuId);

        return "redirect:/student/queryAllPage";
    }

}
