package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.GenericDao;
import com.cosmos.assignment.util.ClassUtil;
import com.cosmos.assignment.util.Util;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
abstract class AbstractGenericDao<P,Q extends Serializable> implements GenericDao<P,Q>
{
	private static int MAX_IN_SIZE = 1000;
	
	@Inject
	private SessionFactory sessionFactory;
	
	private final Class<P> bean;
	
	@SuppressWarnings("unchecked")
	protected AbstractGenericDao()
	{
		bean = (Class<P>) ClassUtil.getTypeArguments(AbstractGenericDao.class, this.getClass()).get(0);
	}
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<P> findAll()
	{
		final Session s = this.getSession();
		final Criteria c = s.createCriteria(bean);
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public P getById(final Q id)
	{
		return (P) getSession().get(bean, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public P loadById(final Q id)
	{
		return (P) getSession().load(bean, id);
	}
	
	@Override
	public void add(final P entity)
	{
		getSession().save(entity);
	}
	
	@Override
	public void delete(final P entity)
	{
		getSession().delete(entity);
	}
	
	@Override
	public void update(final P entity)
	{
		getSession().update(entity);
	}
	
	@Override
	public void deleteById(final Q id)
	{
		final Session s = this.getSession();
		s.delete(s.load(bean, id));
	}
	
	@Override
	public void deleteById(final Q[] id)
	{
		final Session s = this.getSession();
		for(final Q p : id)
		{
			s.delete(s.load(bean, p));
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public P getOne()
	{
		final Session session = getSession();
		final Criteria c = session.createCriteria(bean);
		c.setMaxResults(1);
		return (P) c.uniqueResult();
	}
	
	protected int getTotalRows(final Criteria criteria)
	{
		criteria.setProjection(Projections.projectionList().add(Projections.rowCount()));
		return ((Long)criteria.uniqueResult()).intValue();
	}
	
	protected int getTotalRows()
	{
		final Session s = this.getSession();
		return getTotalRows(s.createCriteria(bean));
	}
	
	protected static Disjunction splitInClause(final String alias, final Object[] values)
	{
		final Disjunction disjunction = Restrictions.disjunction();
		
		if(values.length > MAX_IN_SIZE)
		{
			for(final Object[] o : Util.split(values, MAX_IN_SIZE, new Object[][]{}))
			{
				disjunction.add(Restrictions.in(alias, o));
			}
		}else if(values.length > 0)
		{
			disjunction.add(Restrictions.in(alias, values));
		}else
		{
			/** force to FALSE is values are empty **/
			disjunction.add(Restrictions.sqlRestriction("(0=1)"));
		}
		return disjunction;
	}
	
	
	protected static Object[][] splitInSqlCalsue(final StringBuilder outerSql, final String column, final String paramterNamePrefix, final Object[] values)
	{
		final Object[][] ret;
		if(values.length > MAX_IN_SIZE)
		{
			final StringBuilder sb = new StringBuilder();
			sb.append(" and (1=0 ");
			
			final Object[][] parts = Util.split(values, MAX_IN_SIZE, new Object[][]{});
			for(int i=0;i<parts.length;i++)
			{
				sb.append(String.format("or %s in (:%s%d)", column, paramterNamePrefix, i));
			}
			
			sb.append(")");
			outerSql.append(sb.toString());
			ret = parts;
			
		}else
		{
			outerSql.append(String.format(" and %s in (:%s%d)",column, paramterNamePrefix, 0));
			ret = new Object[][]{values};
		}
		return ret;
	}
}
