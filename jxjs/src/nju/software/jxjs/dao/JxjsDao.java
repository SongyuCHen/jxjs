package nju.software.jxjs.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
		String hql = "from TJxjs jxjs where jxjs.sqsj >= ? and jxjs.sqsj <= ? and jxjs.ajztbh=?";
		List<TJxjs> jxjs = (List<TJxjs>) getHibernateTemplate().find(hql, new Object[]{begin,end,ajztbh});
		return jxjs;
	}
	
	@SuppressWarnings("unchecked")
	public TJxjs getJxjsByBh(int bh){
		String hql = "from TJxjs jxjs where jxjs.jxjsbh=?";
		List<TJxjs> jxjs = (List<TJxjs>) getHibernateTemplate().find(hql, new Object[]{bh});
		if(jxjs != null && jxjs.size()>0)
			return jxjs.get(0);
		else
			return null;
	}
	@SuppressWarnings("unchecked")
	public Integer getMaxBh()
	{
		String hql = "select max(jxjsbh) from TJxjs";
		List<Integer> list = (List<Integer>)getHibernateTemplate().find(hql);
		if(list != null && !list.isEmpty() && list.get(0) != null)
		{
			return list.get(0);
		}
		
		return 0;
	}
	/**
	 * 根据时间段获取减刑假释申请的申请总数
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public int getSqSumByDateAndType(Date kssj,Date jssj){
		String hql = "select count(*) from TJxjs jxjs where jxjs.ajztbh='1'and jxjs.jxjsbh in(select jxjsbh from TSpxx where spxx"+jssj+" and sp.sp";
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);

		int maxbh = 0;
		if (query.uniqueResult() != null)
			maxbh = (Integer) query.uniqueResult();

		
		return maxbh;
	}
	public void save(TJxjs jxjs){
		getHibernateTemplate().save(jxjs);
	}
	
	public void updateJxjs(TJxjs jxjs){
		getHibernateTemplate().update(jxjs);
	}
	
	public void delete(TJxjs jxjs){
		getHibernateTemplate().delete(jxjs);
	}

}
