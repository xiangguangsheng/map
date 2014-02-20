package com.xgs.core.dao;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T, PK extends Serializable> {


        /*
         * 保存
         */
        public PK save(T entity) ;
        /*
         * 保存或更新PO
         */
        public void saveOrUpdate(T entity) ;

        /*
         * 更新PO
         */
        public void update(T entity)  ;

        /*
         * 合并PO
         */
        public void merge(T entity) ; 
        /*
         * 根据id删除PO
         */
        public void delete(PK id) ;

        /*
         * 删除PO
         */
        public void deleteObject(T entity) ;
        /*
         * 根据id判断PO是否存在
         */
        public boolean exists(PK id);
        /*
         * 根据id加载PO
         */
        public T load(PK id) ;
        /*
         * 根据id获取PO
         */
        public T get(PK id) ;

        /*
         * 获取PO总数(默认为entityClass)
         */
        public int countAll();

        /*
         * 根据Criteria查询条件，获取PO总数
         */
        public int countAll(Criteria criteria) ;

        /*
         * 删除所有
         */
        public void deleteAll(Collection<?> entities) ;

        /*
         * 获取全部对象
         */
        public List<T> list();
        /*
         * 获取对象列表根据Criteria
         */
        public List<T> list(Criteria criteria);

        /*
         * 离线查询
         */
        public  List<T> list(DetachedCriteria criteria) ;
        /*
         * 获取全部对象，支持排序
         * 
         * @param orderBy
         * 
         * @param isAsc
         * 
         * @return
         */
        public List<T> list(String orderBy, boolean isAsc);

        /*
         * 按属性查找对象列表，匹配方式为相等
         * 
         * @param propertyName
         * 
         * @param value
         * 
         * @return
         */
        public List<T> list(String propertyName, Object value) ;
        /*
         * 按Criteria查询对象列表
         * 
         * @param criterions数量可变的Criterion
         * 
         * @param criterions
         * 
         * @return
         */
        public List<T> list(Criterion... criterions);

        /*
         * 按属性查找唯一对象，匹配方式为相等
         * 
         * @param propertyName
         * 
         * @param value
         * 
         * @return
         */
        public T uniqueResult(String propertyName, Object value);

        /*
         * 按Criteria查询唯一对象
         * 
         * @param criterions数量可变的Criterion
         * 
         * @param criterions
         * 
         * @return
         */
        public T uniqueResult(Criterion... criterions) ;

        /*
         * 按Criteria查询唯一对象
         * 
         * @param criterions
         * 
         * @return
         */
        public T uniqueResult(Criteria criteria) ;

        /*
         * 为Criteria添加distinct transformer
         * 
         * @param criteria
         * 
         * @return
         */
        // 认为没用
        public Criteria distinct(Criteria criteria);

        /*
         * 强制清空session
         */
        public void flush() ;
        /*
         * 清空session
         */
        public void clear() ;

        /*
         * 创建Criteria实例
         */
        public Criteria createCriteria();

        /*
         * 根据Criterion条件创建Criteria
         * 
         * @param criterions数量可变的Criterion
         */
        public Criteria createCriteria(Criterion... criterions) ;

        /*
         * 分页查询Criteria
         * 
         * @param
         * 
         * @return
         */
        public List<T> findPage(Criteria criteria, int pageNo, int pageSize);

        /*
         * 分页查询Criteria
         * 
         * @param
         * 
         * @return
         */
//        public Page<T> pagedQuery(Criteria criteria, int pageNo, int pageSize) ;


        /*
         * 分页查询Criteria
         * 
         * @param
         * 
         * @return
         */
//        public Page<T> pagedQuery(ConditionQuery conditionQuery, OrderBy orderBy,
//                        int pageNo, int pageSize) {
//                Assert.isTrue(pageNo >= 1, "pageNO should start from 1");
//                Criteria criteria = createCriteria();
//                // 构造查询条件和排序
//                conditionQuery.build(criteria);
//                orderBy.build(criteria);
//                // count查询
//                // 获得查询总数
//                long totalCount = countAll(criteria);
//
//                if (totalCount < 1) {
//                        return new Page<T>();
//                }
//
//                // 实际查询返回分页对象
//                int startIndex = Page.getStartOfPage(pageNo, pageSize);
//                // 返回查询结果集
//                List<T> list = findPage(criteria, pageSize, pageNo);
//
//                return new Page<T>(startIndex, totalCount, pageSize, list);
//        }        
}