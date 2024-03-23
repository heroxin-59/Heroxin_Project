package com.hero.service.impl;

import com.hero.dao.BookMapper;
import com.hero.pojo.Books;
import com.hero.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-27-19:55
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void insertBook(Books book) {
        bookMapper.insertBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public void updateBook(Books books) {
        bookMapper.updateBook(books);
    }

    @Override
    public Books findBookById(int id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public List<Books> findAll() {
        return bookMapper.findAll();
    }
}
