package com.xgs.core.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {
    @Autowired
    private JpaRepository<T, PK> baseDao;

    public JpaRepository<T, PK> getBaseDao() {
        return baseDao;
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);

    }

    @Override
    public void update(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void delete(PK id) {
        baseDao.delete(id);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public void delete(Iterable<? extends T> entities) {
        baseDao.delete(entities);
    }

    @Override
    public boolean exists(PK id) {
        return baseDao.exists(id);
    }

    @Override
    public T get(PK id) {
        return baseDao.findOne(id);
    }

    @Override
    public List<T> list() {
        return (List<T>) baseDao.findAll();
    }

    public void setBaseDao(JpaRepository<T, PK> baseDao) {
        this.baseDao = baseDao;
    }

}
