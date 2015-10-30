package nju.software.jxjs.dao;

import org.hibernate.FlushMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate()
	{
		//hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return hibernateTemplate;
	}

}
