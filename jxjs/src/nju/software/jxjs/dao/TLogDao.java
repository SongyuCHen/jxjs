package nju.software.jxjs.dao;

import java.util.List;

import nju.software.jxjs.model.TLog;

import org.springframework.stereotype.Repository;

@Repository
public class TLogDao extends BaseDao{
	
	@SuppressWarnings("unchecked")
	public Integer getMaxBh()
	{
		String hql = "select max(logid) from TLog";
		List<Integer> list = (List<Integer>)getHibernateTemplate().find(hql);
		if(list != null && !list.isEmpty() && list.get(0) != null)
		{
			return list.get(0);
		}
		
		return 0;
	}
	
	
	public void save(TLog tlog){
		getHibernateTemplate().save(tlog);
		
	}

}
