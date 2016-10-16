package com.example.dao;

import com.example.entity.Book;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookDAO implements com.example.EntityDAO<Book> {
    @Autowired
    private BeanFactory beanFactory;

    @PostConstruct
    public void init() {
        Book book = beanFactory.getBean(Book.class, 1, "title book one");
        this.save(book);
        book = beanFactory.getBean(Book.class, 2, "title book two");
        this.save(book);
        book = beanFactory.getBean(Book.class, 3, "title book three");
        this.save(book);

    }

    @PreDestroy
    public void clear() {
        map.clear();
    }

    private Map<Integer, Book> map = new HashMap<>();

    @Override
    public void save(Book entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public Book findOne(int id) {
        return map.get(id);
    }
}
