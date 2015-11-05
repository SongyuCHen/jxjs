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
	@SuppressWarnings("unchecked")
	public List<TLog> getLogByDateAndType(String begin,String end,String type){
		String hql = "";
		if(begin!=null && end!= null)
			hql = "from TLog where czsj>='"+begin+"' and czsj<='"+end+"'";
		else if(begin!=null)
			hql = "from TLog where czsj>='"+begin+"'";
		else if(end != null)
			hql = "from TLog where czsj<='"+end+"'";
		else
			hql = "from TLog";
		if(type!=null && hql.contains("where"))
			hql += " and type='"+type+"'";
		else if(type!=null)
			hql =  "from TLog where type='"+type+"'";
		List<TLog> logs = (List<TLog>) getHibernateTemplate().find(hql);
		return logs;
	}
	
	
	public void save(TLog tlog){
		getHibernateTemplate().save(tlog);
		
	}

}
