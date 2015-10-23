package nju.software.jxjs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import nju.software.jxjs.model.TJxjs;

@Repository
public class JxjsDao extends BaseDao {
	
	@SuppressWarnings("unchecked")
	public List<TJxjs> getJxjsByAjztbh(String ajztbh){
		String hql = "from TJxjs jxjs where jxjs.ajztbh=?";
		List<TJxjs> jxjs = (List<TJxjs>) getHibernateTemplate().find(hql, new Object[]{ajztbh});
		return jxjs;
	}

}
