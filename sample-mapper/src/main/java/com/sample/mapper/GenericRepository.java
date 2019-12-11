package com.sample.mapper;

import java.util.List;

public interface GenericRepository {
    <T> Integer save(T entity);

    <T> Integer update(T entity);

    <T> T selectById(Long id);

    <T> List<T> findList(Object parameter);
}
