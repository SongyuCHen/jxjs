package nju.software.jxjs.dao;

import java.util.List;

import nju.software.jxjs.model.PubLaAy;

import org.springframework.stereotype.Repository;

@Repository
public class PubLaAyDao extends BaseDao {
	public List<PubLaAy> getAyByAjxh(int ajxh){
		String hql = "from PubLaAy ay where ay.ajxh=?";
		List<PubLaAy> ayList = (List<PubLaAy>) getHibernateTemplate().find(hql, new Object[]{ajxh});
		return ayList;
	}

}
