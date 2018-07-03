package br.com.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.util.HibernateUtil;

public class ImplementacaoCrud<T> {

	private static SessionFactory sessionFactory;

	public void save(Object obj) throws Exception {
		validaSessionFactory();
		
		sessionFactory.getCurrentSession().save(obj);
		executeFlushSession();

	}

	public void persist(Object obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().persist(obj);
		executeFlushSession();

	}

	public void saveOrUpdate(Object obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		executeFlushSession();

	}

	public void update(Object obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().update(obj);
		executeFlushSession();

	}

	public void delete(Object obj) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().delete(obj);
		executeFlushSession();
	}

	public Object merge(Object obj) throws Exception {
		validaSessionFactory();
		obj = (T) sessionFactory.getCurrentSession().merge(obj);
		executeFlushSession();
		return obj;
	}

	public void clearSession() throws Exception {
		sessionFactory.getCurrentSession().clear();

	}

	public void evict(Object objs) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().evict(objs);

	}

	public Session getSession() throws Exception {
		validaSessionFactory();
		return sessionFactory.getCurrentSession();
	}

	private void validaSessionFactory() throws Exception {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	private void executeFlushSession() {
		sessionFactory.getCurrentSession().flush();
	}
}
