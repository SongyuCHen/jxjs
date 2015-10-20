package nju.software.jxjs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import nju.software.jxjs.model.TSpxx;

@Repository
public class SpxxDao extends BaseDao {
	public List<TSpxx> getSPxxByJxjsbh(int jxjsbh){
		String hql = "from TSpxx sp where sp.username=?";
		List<TSpxx> spxx = (List<TSpxx>) getHibernateTemplate().find(hql, new Object[]{jxjsbh});
		return spxx;
	}

}
