package nju.software.jxjs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.TXsaj;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.connection.ConnectionProvider;
import org.springframework.stereotype.Repository;

@Repository
public class PubAjJbDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getAjJbByJarq(Date begin,Date end){
		String hql = "from PubAjJb aj where aj.jarq>=? and aj.jarq<=?";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{begin,end});
		return ajList;
	}
	
	@SuppressWarnings("unchecked")
	public PubAjJb getAjJbByAjxh(int ajxh){
		String hql = "from PubAjJb aj where aj.ajxh=?";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{ajxh});
		if(ajList!=null &&ajList.size()>0)
			return ajList.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public PubAjJb getAjJbByAh(String ah){
		String hql = "from PubAjJb aj where aj.ah=?";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{ah});
		if(ajList!=null &&ajList.size()>0)
			return ajList.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaxBh(){
		String hql = "select max(ajxh) from PubAjJb";
		List<Integer> list = (List<Integer>)getHibernateTemplate().find(hql);
		if(list != null && !list.isEmpty() && list.get(0) != null)
		{
			return list.get(0);
		}
		
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public int getMaxAh(String year,String dz,String bydz,String ah_filter){
		String sql = "SELECT max(convert(integer,substring(AH ,  charindex('"+dz+"',AH) +2 , " +
				"charindex('号',AH) - charindex('"+dz+"',AH) - 2)))"
				+ " FROM PUB_AJ_JB  "
				+ " WHERE "
				+ "		( AH not like '%X%') AND "
				+ "		( AH not like '%XX%' ) AND "
				+ "		( AH not like '%-%'  ) AND "
				+ "		( AH not like '%第%'  ) AND "
				+ "		( AH like '"+ year+ "' ) AND "
				+ "		( AH like '"+ ah_filter+ "' ) AND "
				+ "		( BYCXDZ  like '" + bydz + "' ) ";
//		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
//		Query query = s.createQuery(sql);
//		int maxAh = (int)query.uniqueResult();
//		return maxAh;
		ConnectionProvider cp = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Integer max = 0;
		try {
			cp = ((SessionFactoryImplementor) this.getHibernateTemplate()
					.getSessionFactory()).getConnectionProvider();
			connection = cp.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				max = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			max = -1;
			
		}finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (cp != null)
					cp.closeConnection(connection);
			} catch (SQLException e) {
				
				max =-1;
			}
		}
		return max;

		
	}
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getXSajByJarq(Date begin,Date end){
		String hql = "from PubAjJb aj where aj.jarq>=? and aj.jarq<=? and aj.ajxz = '1' and aj.ajxh not in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{begin,end});
		return ajList;
	}
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getXSajAfterJarq(Date begin){
		String hql = "from PubAjJb aj where aj.jarq>=? and aj.ajxz = '1' and aj.ajxh not in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{begin});
		return ajList;
	}
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getXSajBeforeJarq(Date end){
		String hql = "from PubAjJb aj where aj.jarq<=? and aj.ajxz = '1' and aj.ajxh not in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{end});
		return ajList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getCsaj(Date begin,Date end){
		String hql = "select aj.ah,aj.ajmc,aj.larq,aj.jarq,aj.bafy from PubAjJb aj where aj.larq>=? and aj.larq<=? and aj.ajxh in(select ajxh from TXsaj)";		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		List<PubAjJb> ajList = null;
		if(query.uniqueResult() != null){
			ajList = (List<PubAjJb>) query.uniqueResult();
		}
			

		return ajList;
	}
	
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getCSajAfterLarq(Date begin){
		String hql = "from PubAjJb aj where aj.larq>=? and aj.ajxz = '1' and aj.ajxh in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{begin});
		return ajList;
	}
	
	@SuppressWarnings("unchecked")
	public List<PubAjJb> getCSajBeforeLarq(Date end){
		String hql = "from PubAjJb aj where aj.larq<=? and aj.ajxz = '1' and aj.ajxh in(select ajxh from TXsaj)";
		List<PubAjJb> ajList = (List<PubAjJb>) getHibernateTemplate().find(hql, new Object[]{end});
		return ajList;
	}
	
	public void addXsajTrans(TXsaj xsaj){
		getHibernateTemplate().save(xsaj);
	}
	

	
	public void save(PubAjJb aj){
		getHibernateTemplate().save(aj);
	}
	public void update(PubAjJb aj){
		getHibernateTemplate().update(aj);
	}
	public void delete(PubAjJb aj){
		getHibernateTemplate().delete(aj);
	}

}
