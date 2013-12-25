package com.xgs.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
	// 日志输出类
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(BaseDaoImpl.class);

	// 泛型反射类
	private Class<T> entityClass;

	// 通过反射获取子类确定的泛型类
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/*
	 * 注入sessionFactory
	 */
	@Resource
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * 保存PO
	 */
	@SuppressWarnings("unchecked")
	public PK save(T entity) {
		Session session = getSession();
		PK pk = (PK) session.save(entity);
		return pk;
	}

	/*
	 * 保存或更新PO
	 */
	public void saveOrUpdate(T entity) {
		Session session = getSession();
		session.saveOrUpdate(entity);
		// session.close();
		// getSession().saveOrUpdate(entity);
	}

	/*
	 * 更新PO
	 */
	public void update(T entity) {
		getSession().update(entity);

	}

	/*
	 * 合并PO
	 */
	public void merge(T entity) {
		getSession().merge(entity);
	}

	/*
	 * 根据id删除PO
	 */
	public void delete(PK id) {
		Session session = getSession();
		session.delete(this.get(id));

	}

	/*
	 * 删除PO
	 */
	public void deleteObject(T entity) {
		Session session = getSession();
		session.delete(entity);
	}

	/*
	 * 根据id判断PO是否存在
	 */
	public boolean exists(PK id) {
		return get(id) != null;
	}

	/*
	 * 根据id加载PO
	 */
	@SuppressWarnings("unchecked")
	public T load(PK id) {
		Session session = getSession();
		T t = (T) session.load(this.entityClass, id);
		return t;
	}

	/*
	 * 根据id获取PO
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Session session = getSession();
		T t = (T) session.get(this.entityClass, id);
		return t;
	}

	/*
	 * 获取PO总数(默认为entityClass)
	 */
	public int countAll() {
		Criteria criteria = createCriteria();
		return Integer.valueOf(criteria.setProjection(Projections.rowCount())
				.uniqueResult().toString());
	}

	/*
	 * 根据Criteria查询条件，获取PO总数
	 */
	public int countAll(Criteria criteria) {
		return Integer.valueOf(criteria.setProjection(Projections.rowCount())
				.uniqueResult().toString());
	}

	/*
	 * 删除所有
	 */
	public void deleteAll(Collection<?> entities) {
		if (entities == null)
			return;
		for (Object entity : entities) {
			getSession().delete(entity);
		}
		// session.close();
	}

	/*
	 * 获取全部对象
	 */
	@SuppressWarnings("unchecked")
	public List<T> list() {
		List<T> list = createCriteria().list();
		return list;
	}

	/*
	 * 获取对象列表根据Criteria
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Criteria criteria) {
		List<T> list = criteria.list();
		return list;
	}

	/*
	 * 离线查询
	 */
	public List<T> list(DetachedCriteria criteria) {
		return (List<T>) list(criteria.getExecutableCriteria(getSession()));
	}

	/*
	 * 获取全部对象，支持排序
	 * 
	 * @param orderBy
	 * 
	 * @param isAsc
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(String orderBy, boolean isAsc) {
		Criteria criteria = createCriteria();
		if (isAsc) {
			criteria.addOrder(Order.asc(orderBy));
		} else {
			criteria.addOrder(Order.desc(orderBy));
		}
		return criteria.list();
	}

	/*
	 * 按属性查找对象列表，匹配方式为相等
	 * 
	 * @param propertyName
	 * 
	 * @param value
	 * 
	 * @return
	 */
	public List<T> list(String propertyName, Object value) {
		Criterion criterion = Restrictions
				.like(propertyName, "%" + value + "%");
		return list(criterion);
	}

	/*
	 * 根据查询条件获取数据列表
	 */
	@SuppressWarnings("unchecked")
	private List<T> list(Criterion criterion) {
		Criteria criteria = createCriteria();
		criteria.add(criterion);
		return criteria.list();
	}

	/*
	 * 按Criteria查询对象列表
	 * 
	 * @param criterions数量可变的Criterion
	 * 
	 * @param criterions
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	/*
	 * 按属性查找唯一对象，匹配方式为相等
	 * 
	 * @param propertyName
	 * 
	 * @param value
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T uniqueResult(String propertyName, Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		T t = (T) createCriteria(criterion).uniqueResult();
		return t;
	}

	/*
	 * 按Criteria查询唯一对象
	 * 
	 * @param criterions数量可变的Criterion
	 * 
	 * @param criterions
	 * 
	 * @return
	 */
	public T uniqueResult(Criterion... criterions) {
		Criteria criteria = createCriteria(criterions);
		return uniqueResult(criteria);
	}

	/*
	 * 按Criteria查询唯一对象
	 * 
	 * @param criterions
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T uniqueResult(Criteria criteria) {
		T t = (T) criteria.uniqueResult();
		return t;
	}

	/*
	 * 为Criteria添加distinct transformer
	 * 
	 * @param criteria
	 * 
	 * @return
	 */
	// 认为没用
	public Criteria distinct(Criteria criteria) {
		// 将结果集进行一次封装，封装成DISTINCT_ROOT_ENTITY对象，方便service层代码使用
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	/*
	 * 强制清空session
	 */
	public void flush() {
		getSession().flush();
	}

	/*
	 * 清空session
	 */
	public void clear() {
		getSession().clear();
	}

	/*
	 * 创建Criteria实例
	 */
	public Criteria createCriteria() {
		Session session = getSession();
		Criteria Criteria = session.createCriteria(entityClass);
		return Criteria;
	}

	/*
	 * 根据Criterion条件创建Criteria
	 * 
	 * @param criterions数量可变的Criterion
	 */
	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = createCriteria();
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	/*
	 * 分页查询Criteria
	 * 
	 * @param
	 * 
	 * @return
	 */
	public List<T> findPage(Criteria criteria, int pageNo, int pageSize) {
		// 设置起始结果数
		criteria.setFirstResult((pageNo - 1) * pageSize);
		// 返回的最大结果集
		criteria.setMaxResults(pageSize);
		return list(criteria);
	}

	/*
	 * 分页查询Criteria
	 * 
	 * @param
	 * 
	 * @return
	 */
	// public Page<T> pagedQuery(Criteria criteria, int pageNo, int pageSize) {
	// Assert.isTrue(pageNo >= 1, "pageNO should start from 1");
	//
	// // 返回查询结果集
	// List<T> list = findPage(criteria, pageNo, pageSize);
	// /*
	// * 注：因为finaPage方法改变了查询条件导致countALL方法查询为空， 所以必须重新设置setFirstResult为0
	// */
	// criteria.setFirstResult(0);
	// // count查询
	// // 获得查询总数
	// long totalCount = countAll(criteria);
	//
	// if (totalCount < 1) {
	// return new Page<T>();
	// }
	//
	// // 实际查询返回分页对象
	// int startIndex = Page.getStartOfPage(pageNo, pageSize);
	//
	// return new Page<T>(startIndex, totalCount, pageSize, list);
	// }

	/*
	 * 分页查询Criteria
	 * 
	 * @param
	 * 
	 * @return
	 */
	// public Page<T> pagedQuery(ConditionQuery conditionQuery, OrderBy orderBy,
	// int pageNo, int pageSize) {
	// Assert.isTrue(pageNo >= 1, "pageNO should start from 1");
	// Criteria criteria = createCriteria();
	// // 构造查询条件和排序
	// conditionQuery.build(criteria);
	// orderBy.build(criteria);
	// // count查询
	// // 获得查询总数
	// long totalCount = countAll(criteria);
	//
	// if (totalCount < 1) {
	// return new Page<T>();
	// }
	//
	// // 实际查询返回分页对象
	// int startIndex = Page.getStartOfPage(pageNo, pageSize);
	// // 返回查询结果集
	// List<T> list = findPage(criteria, pageSize, pageNo);
	//
	// return new Page<T>(startIndex, totalCount, pageSize, list);
	// }

}