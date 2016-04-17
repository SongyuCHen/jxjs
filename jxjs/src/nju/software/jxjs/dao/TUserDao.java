package nju.software.jxjs.dao;

import java.util.List;

import nju.software.jxjs.model.TUser;

import org.springframework.stereotype.Repository;


@Repository
public class TUserDao extends BaseDao{
	
	
	@SuppressWarnings("unchecked")
	public TUser findUser(String name){
		String hql = "from TUser u where u.name=?";
		List<TUser> list = (List<TUser>) getHibernateTemplate().find(hql, new Object[]{name});
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public TUser findUsername(String username){
		String hql = "from TUser u where u.username=?";
		List<TUser> list = (List<TUser>) getHibernateTemplate().find(hql, new Object[]{username});
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public TUser getUserById(int yhbh){
		String hql = "from TUser u where u.userbh=?";
		List<TUser> list = (List<TUser>) getHibernateTemplate().find(hql, new Object[]{yhbh});
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
}
