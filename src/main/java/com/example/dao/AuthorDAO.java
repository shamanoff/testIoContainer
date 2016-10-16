package com.example.dao;

import com.example.entity.Author;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthorDAO implements com.example.EntityDAO<Author> {
    @Autowired
    private BeanFactory beanFactory;

    @PostConstruct
    public void init() {
        Author author = beanFactory.getBean(Author.class, "John Dreik", 1, 1);
        this.save(author);
        author = beanFactory.getBean(Author.class, "Bob Dylan", 2, 2);
        this.save(author);
        author = beanFactory.getBean(Author.class, "Charlz Darvin", 3, 3);
        this.save(author);
    }

    private Map<Integer, Author> map = new HashMap<>();

    @Override
    public void save(Author entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public Author findOne(int id) {
        return map.get(id);
    }
}
