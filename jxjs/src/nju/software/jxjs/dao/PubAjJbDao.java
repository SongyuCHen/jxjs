package nju.software.jxjs.dao;

import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.TXsaj;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class PubAjJbDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getAjJbByJarq(Date begin,Date end){
		String hql = "from PubAjJb aj where aj.jarq>=? and aj.jarq<=?";
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
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getXSajByJarq(Date begin,Date end){
		String hql = "from PubAjJb aj where aj.jarq>=? and aj.jarq<=? and aj.ajxz = '1' and aj.ajxh not in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{begin,end});
		return ajList;
	}
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getXSajAfterJarq(Date begin){
		String hql = "from PubAjJb aj where aj.jarq>=? and aj.ajxz = '1' and aj.ajxh not in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{begin});
		return ajList;
	}
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getXSajBeforeJarq(Date end){
		String hql = "from PubAjJb aj where aj.jarq<=? and aj.ajxz = '1' and aj.ajxh not in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{end});
		return ajList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getCsaj(Date begin,Date end){
		String hql = "select aj.ah,aj.ajmc,aj.larq,aj.jarq,aj.bafy from PubAjJb aj where aj.larq>=? and aj.larq<=? and aj.ajxh in(select ajxh from TXsaj)";		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		List<PubAjJb> ajList = null;
		if(query.uniqueResult() != null){
			ajList = (List<PubAjJb>) query.uniqueResult();
		}
			

		return ajList;
	}
	
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getCSajAfterLarq(Date begin){
		String hql = "from PubAjJb aj where aj.larq>=? and aj.ajxz = '1' and aj.ajxh in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{begin});
		return ajList;
	}
	
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getCSajBeforeLarq(Date end){
		String hql = "from PubAjJb aj where aj.larq<=? and aj.ajxz = '1' and aj.ajxh in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{end});
		return ajList;
	}
	
	public void addXsajTrans(TXsaj xsaj){
		getHibernateTemplate().save(xsaj);
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
