package nju.software.jxjs.dao;

import java.util.List;

import nju.software.jxjs.model.TJxjs;

public class JxjsDao extends BaseDao {
	public List<TJxjs> getJxjsByAjztbh(int ajztbh){
		String hql = "from TJxjs jxjs where jxjs.ajzt=?";
		List<TJxjs> jxjs = (List<TJxjs>) getHibernateTemplate().find(hql, new Object[]{ajztbh});
		return jxjs;
	}

}
