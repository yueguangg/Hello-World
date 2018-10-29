package demo.springboot.service.impl;

import demo.springboot.domain.Book;
import demo.springboot.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Book 业务层实现
 *
 */
@Service
public class BookServiceImpl implements BookService {

    // 模拟数据库，存储 Book 信息
    // 第五章《﻿数据存储》会替换成 MySQL 存储
    private static Map<Long, Book> BOOK_DB = new HashMap<>();

    @Override
    public List<Book> findAll() {
        Book b1 = new Book();
        b1.setId(1L);
        b1.setName("基督山伯爵");
        BOOK_DB.put(1L,b1);
        Book b2 = new Book();
        b2.setId(2L);
        b2.setName("聖經");
        BOOK_DB.put(2L,b2);
        return new ArrayList<>(BOOK_DB.values());
    }

    @Override
    public Book insertByBook(Book book) {
        book.setId(BOOK_DB.size() + 1L);
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(Book book) {
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        return BOOK_DB.remove(id);
    }

    @Override
    public Book findById(Long id) {
        return BOOK_DB.get(id);
    }
}
