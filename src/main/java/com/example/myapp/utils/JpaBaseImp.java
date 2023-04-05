package com.example.myapp.utils;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Getter
@Transactional
public class JpaBaseImp <T, ID extends Serializable, R extends JpaBase<T, ID>, D> implements DaoBase<T, ID>{

    private R dao;
    private final Class<R> daoClass;
    private final Class<T> entityClass;
    private final Class<D> dtoClass;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @PostConstruct
    private void initial() {
        dao = beanFactory.getBean(daoClass);
    }

    public JpaBaseImp(Class<R> daoClass, Class<T> entityClass, Class<D> dtoClass) {
        this.daoClass = daoClass;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<T> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        return dao.findAll();
    }

    @Override
    public void save(T t) {
        dao.saveAndFlush(t);
    }

    @Override
    public void delete(T t) {
        dao.deleteInBatch((Iterable<T>) t);
    }



    public D entityToDto(T entity){
        D dto = modelMapper.map(entity, dtoClass);
        //set parent entity прописать
        return dto;
    }
}
