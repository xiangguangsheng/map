package com.xgs.core.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, PK extends Serializable> {
    /*
     * 保存或更新PO
     */
    public void save(T entity);

    /*
     * 更新PO
     */
    public void update(T entity);

    /*
     * 根据id删除PO
     */
    public void delete(PK id);

    public void delete(Iterable<? extends T> entities);

    /*
     * 删除PO
     */
    public void delete(T entity);

    /*
     * 根据id判断PO是否存在
     */
    public boolean exists(PK id);

    /*
     * 根据id获取PO
     */
    public T get(PK id);

    public List<T> list();
}
