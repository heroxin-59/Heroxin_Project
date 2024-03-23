package com.hero.mapper;

import com.hero.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-30-15:05
 * @Description:
 */
public interface StudentMapper {

//    添加学生
    @Insert("insert into student values(#{stuId},#{stuName},#{stuGender},#{stuHome},#{stuProfession},#{stuTel},#{stuAddress})")
    void insert(Student student);

//    删除学生
    @Delete("delete from student where stuId = #{stuId}")
    void delete(int stuId);

//    修改学生信息
    @Update("update student set " +
            "stuName=#{stuName},stuGender = #{stuGender},stuHome=#{stuHome}," +
            "stuProfession=#{stuProfession}," +
            "stuTel=#{stuTel},stuAddress=#{stuAddress} where stuId = #{stuId}")
    void update(Student student);

//    查询一个学生的信息
    @Select("select * from student where stuId = #{stuId}")
    Student query(int stuId);

//    查询所有学生信息
    @Select("select * from student")
    List<Student> queryAll();

//    查询所有学生信息 —— 分页查询
    @Select("select * from student limit #{start},#{count};")
//    此处 @Param 重要，用于绑定参数，便于系统识别，不可省略，不然爆 500
    List<Student> queryAllPages(@Param("start") int start,@Param("count") int count);

//    查询学生个数
    @Select("select count(*) from student")
    int queryNum();

}
