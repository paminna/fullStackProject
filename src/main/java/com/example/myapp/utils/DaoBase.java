package com.example.myapp.utils;

import java.util.List;
import java.util.Optional;

/**
 * Базовые интерфейс для работы с сущностями бд.
 * @param <T>
 * @param <ID>
 */
public interface DaoBase <T, ID>{
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void delete(T t);

    List<T> findAll();
}
