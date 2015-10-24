package nju.software.jxjs.dao;

import java.util.Date;
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
	@SuppressWarnings("unchecked")
	public List<TJxjs> getJxjsByDateAndAjztbh(Date begin,Date end,String ajztbh){
		String hql = "from TJxjs jxjs where jxjs.sqsj >= begin and jxjs.sqsj <= end and jxjs.ajztbh=?";
		List<TJxjs> jxjs = (List<TJxjs>) getHibernateTemplate().find(hql, new Object[]{begin,end,ajztbh});
		return jxjs;
	}

}
