package nju.software.jxjs.dao;

import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.PubAjJb;

import org.springframework.stereotype.Repository;

@Repository
public class PubAjJbDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getAjJbByLarq(Date begin,Date end){
		String hql = "from PubAjJb aj where aj.larq>=? and aj.larq<=?";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{begin,end});
		return ajList;
	}
	
	@SuppressWarnings("unchecked")
	public PubAjJb getAjJbByAjxh(int ajxh){
		String hql = "from PubAjJb aj where aj.ajxh=?";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{ajxh});
		if(ajList!=null &&ajList.size()>0)
			return ajList.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public PubAjJb getAjJbByAh(String ah){
		String hql = "from PubAjJb aj where aj.ah=?";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{ah});
		if(ajList!=null &&ajList.size()>0)
			return ajList.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxBh(){
		String hql = "select max(ajxh) from PubAjJb";
		List<Integer> list = (List<Integer>)getHibernateTemplate().find(hql);
		if(list != null && !list.isEmpty() && list.get(0) != null)
		{
			return list.get(0);
		}
		
		return 0;
	}
	public void save(PubAjJb aj){
		getHibernateTemplate().save(aj);
	}
	public void update(PubAjJb aj){
		getHibernateTemplate().update(aj);
	}
	public void delete(PubAjJb aj){
		getHibernateTemplate().delete(aj);
	}

}
