package nju.software.jxjs.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.util.DateUtil;

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
	public int getSqSumByDate(Date kssj,Date jssj){
		String s_kssj = DateUtil.format(kssj, DateUtil.webFormat);
		String s_jssj = DateUtil.format(jssj, DateUtil.webFormat);
		String hql = "select count(*) from TJxjs jxjs where jxjs.sqsj>='"+s_kssj+"' and jxjs.sqsj <='"+s_jssj+"'";
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		int sz = 0;
		if (query.uniqueResult() != null)			
			sz = Integer.parseInt(String.valueOf(query.uniqueResult())); 
		return sz;
	}
	/**
	 * 根据时间段获取减刑假释申请的审批总数
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public int getSpSumByDate(Date kssj,Date jssj){
		String s_kssj = DateUtil.format(kssj, DateUtil.webFormat);
		String s_jssj = DateUtil.format(jssj, DateUtil.webFormat);
		String hql = "select count(*) from TSpxx spxx where spxx.splx = '1' and spxx.spsj>='"+s_kssj+"' and spxx.spsj <='"+s_jssj+"'";
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		int sz = 0;
		if (query.uniqueResult() != null)
			sz = Integer.parseInt(String.valueOf(query.uniqueResult())); 
		return sz;
	}
	/**
	 * 根据时间段获取减刑假释申请的立案总数
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public int getlaSumByDate(Date kssj,Date jssj){
		String s_kssj = DateUtil.format(kssj, DateUtil.webFormat);
		String s_jssj = DateUtil.format(jssj, DateUtil.webFormat);
		String hql = "select count(*) from PubAjJb aj where aj.ajxh in(select laajxh from TJxjs) and aj.larq>='"+s_kssj+"' and aj.larq <='"+s_jssj+"'";
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		int sz = 0;
		if (query.uniqueResult() != null)
			sz = Integer.parseInt(String.valueOf(query.uniqueResult())); 
		return sz;
	}
	/**
	 * 根据时间段获取减刑假释申请的结案总数
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public int getjaSumByDate(Date kssj,Date jssj){
		String s_kssj = DateUtil.format(kssj, DateUtil.webFormat);
		String s_jssj = DateUtil.format(jssj, DateUtil.webFormat);
		String hql = "select count(*) from PubAjJb aj where aj.ajxh in(select laajxh from TJxjs) and aj.jarq>='"+s_kssj+"' and aj.jarq <='"+s_jssj+"'";
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		int sz = 0;
		if (query.uniqueResult() != null)
			sz = Integer.parseInt(String.valueOf(query.uniqueResult())); 
		return sz;
	}
	/**
	 * 根据时间段获取减刑假释申请的结案总数
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public int getfkSumByDate(Date kssj,Date jssj){
		String s_kssj = DateUtil.format(kssj, DateUtil.webFormat);
		String s_jssj = DateUtil.format(jssj, DateUtil.webFormat);
		String hql = "select count(*) from PubAjJb aj where aj.ajxh in(select laajxh from TJxjs) and aj.jarq>='"+s_kssj+"' and aj.jarq <='"+s_jssj+"'";
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		int sz = 0;
		if (query.uniqueResult() != null)
			sz = Integer.parseInt(String.valueOf(query.uniqueResult())); 
		return sz;
	}
	
	/**
	 * 根据申请时间段获取减刑假释申请的不同状态的总数
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public int getSumByCondition(Date kssj,Date jssj,String type){
		String s_kssj = DateUtil.format(kssj, DateUtil.webFormat);
		String s_jssj = DateUtil.format(jssj, DateUtil.webFormat);
		String hql = "select count(*) from TJxjs jxjs where jxjs.ajztbh ='"+type+"' and jxjs.sqsj>='"+s_kssj+"' and jxjs.sqsj <='"+s_jssj+"'";		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		int sz = 0;
		if (query.uniqueResult() != null)
			sz = Integer.parseInt(String.valueOf(query.uniqueResult())); 
		return sz;
	}
	
	/**
	 * 根据申请时间段获取减刑或者假释申请的不同状态的总数
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public int getSumByConditionAndLx(Date kssj,Date jssj,String type,String sqlx){
		String s_kssj = DateUtil.format(kssj, DateUtil.webFormat);
		String s_jssj = DateUtil.format(jssj, DateUtil.webFormat);
		String hql = "select count(*) from TJxjs jxjs where jxjs.ajztbh ='"+type+"' and jxjs.sqlxbh = '"+sqlx+"' and jxjs.sqsj>='"+s_kssj+"' and jxjs.sqsj <='"+s_jssj+"'";		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		int sz = 0;
		if (query.uniqueResult() != null)
			sz = Integer.parseInt(String.valueOf(query.uniqueResult())); 
		return sz;
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
