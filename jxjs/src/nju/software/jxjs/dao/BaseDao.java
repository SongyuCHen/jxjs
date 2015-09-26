package nju.software.jxjs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BaseDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}

}
