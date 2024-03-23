package com.hero.dao;

import com.hero.pojo.Books;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-27-17:21
 * @Description:
 */

public interface BookMapper {

//    增加一本书
    @Insert("insert into books values(#{bookId},#{bookName},#{bookCounts},#{detail})")
    public void insertBook(Books book);

//    删除一本书
    @Delete("delete from books where bookId=#{bookId}")
    public void deleteBook(int id);

//    修改一本书
    @Update("update books set bookName=#{bookName},bookCounts=#{bookCounts},detail=#{detail} where bookId=#{bookId}")
    public void updateBook(Books books);

//    查询一本书
    @Select("select * from books where bookId=#{bookId}")
    public Books findBookById(int id);
//    查询所有书
    @Select("select * from books")
    public List<Books> findAll();
}
