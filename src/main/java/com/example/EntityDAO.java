package com.example;

public interface EntityDAO <T extends Entity> {

    void save(T entity);

    T findOne(int id);
}
