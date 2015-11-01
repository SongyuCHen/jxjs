package nju.software.jxjs.dao;

import java.util.List;

import nju.software.jxjs.model.TDsr;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class TDsrDao extends BaseDao {
	@SuppressWarnings("unchecked")	
	public TDsr getDsrByJxjsbh(int jxjsbh){
		String hql = "from TDsr dsr where dsr.jxjsbh=?";
		List<TDsr> dsrList = (List<TDsr>) getHibernateTemplate().find(hql, new Object[]{jxjsbh});
		if(dsrList!=null && dsrList.size()>0)
			return dsrList.get(0);
		else
			return null;		
	}
	public Integer getMaxDsrbh() {
		String hql = "select max(dsrbh) from TDsr";
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);

		int maxbh = 0;
		if (query.uniqueResult() != null)
			maxbh = (Integer) query.uniqueResult();

		
		return maxbh;
	}
	
	public void save(TDsr dsr){
		getHibernateTemplate().save(dsr);
	}

}
