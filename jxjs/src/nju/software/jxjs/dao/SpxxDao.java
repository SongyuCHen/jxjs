package nju.software.jxjs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import nju.software.jxjs.model.TSpxx;


@Repository
public class SpxxDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<TSpxx> getSPxxByJxjsbh(int jxjsbh){
		String hql = "from TSpxx sp where sp.jxjsbh=?";
		List<TSpxx> spxx = (List<TSpxx>) getHibernateTemplate().find(hql, new Object[]{jxjsbh});
		return spxx;
	}
	@SuppressWarnings("unchecked")
	public Integer getMaxBh()
	{
		String hql = "select max(spxxbh) from TSpxx";
		List<Integer> list = (List<Integer>)getHibernateTemplate().find(hql);
		if(list != null && !list.isEmpty() && list.get(0) != null)
		{
			return list.get(0);
		}
		
		return 0;
	}

	public void save(TSpxx spxx){
		getHibernateTemplate().save(spxx);
	}
	public void update(TSpxx spxx){
		getHibernateTemplate().update(spxx);
	}
	public void delete(TSpxx spxx){
		getHibernateTemplate().delete(spxx);
	}

}
