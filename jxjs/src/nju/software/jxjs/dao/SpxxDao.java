package nju.software.jxjs.dao;

import java.util.List;

import nju.software.jxjs.model.TSpxx;

public class SpxxDao extends BaseDao {
	public List<TSpxx> getSPxxByJxjsbh(int jxjsbh){
		String hql = "from TSpxx sp where sp.username=?";
		List<TSpxx> spxx = (List<TSpxx>) getHibernateTemplate().find(hql, new Object[]{jxjsbh});
		return spxx;
	}

}
