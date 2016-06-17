package nju.software.jxjs.dao;

import java.util.List;

import nju.software.jxjs.model.PubDmb;

import org.springframework.stereotype.Repository;

@Repository
public class XtglDmbDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<PubDmb> getDmbByLbbh(String lbbh){
		String hql = "from PubDmb dmb where dmb.lbbh=?";
		List<PubDmb> dmbs =  (List<PubDmb>) getHibernateTemplate().find(hql, new Object[]{lbbh});
		return dmbs;
	}
	@SuppressWarnings("unchecked")
	public PubDmb getDmbByLbbhAndDmms(String lbbh,String dmms){
		String hql = "from PubDmb dmb where dmb.lbbh=? and dmb.dmms=?";
		List<PubDmb> dmbs =  (List<PubDmb>) getHibernateTemplate().find(hql, new Object[]{lbbh,dmms});
		if(dmbs != null && dmbs.size() > 0)
			return dmbs.get(0);
		else
			return null;
	}
	@SuppressWarnings("unchecked")
	public PubDmb getDmbByLbbhAndDmbh(String lbbh,String dmbh){
		String hql = "from PubDmb dmb where dmb.lbbh=? and dmb.dmbh=?";
		List<PubDmb> dmbs =  (List<PubDmb>) getHibernateTemplate().find(hql, new Object[]{lbbh,dmbh});
		if(dmbs != null && dmbs.size() > 0)
			return dmbs.get(0);
		else
			return null;
	}
	
	public PubDmb getDmbByLbbhAndLikeXgdm(String lbbh,String xgdm){
		String hql = "from PubDmb dmb where dmb.lbbh=? and xgdm like '%" + xgdm+ "%'";
		List<PubDmb> dmbs =  (List<PubDmb>) getHibernateTemplate().find(hql, new Object[]{lbbh});
		if(dmbs != null && dmbs.size() > 0)
			return dmbs.get(0);
		else
			return null;
	}
	

}
