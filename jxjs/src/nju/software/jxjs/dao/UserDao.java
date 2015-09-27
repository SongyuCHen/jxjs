package nju.software.jxjs.dao;

import java.util.List;

import nju.software.jxjs.model.TUser;

import org.springframework.stereotype.Repository;


@Repository
public class UserDao extends BaseDao{
	
	
	@SuppressWarnings("unchecked")
	public TUser findUser(String username){
		String hql = "from TUser u where u.username=?";
		List<TUser> list = (List<TUser>) getHibernateTemplate().find(hql, new Object[]{username});
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
}
