package nju.software.jxjs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.DsrJb;
import nju.software.jxjs.model.DsrJbId;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * DsrJb entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see software.tjspxt.data.dataobject.DsrJb
 * @author MyEclipse Persistence Tools
 */
@Repository
public class DsrJbDao extends BaseDao {
	private static final Logger log = LoggerFactory.getLogger(DsrJbDao.class);
	// property constants
	public static final String DSRSSDW = "dsrssdw";
	public static final String DSRLB = "dsrlb";
	public static final String DSRJC = "dsrjc";
	public static final String SFSSDBR = "sfssdbr";
	public static final String DSRBGFS = "dsrbgfs";
	public static final String DSRBGYY = "dsrbgyy";
	public static final String SFSA = "sfsa";
	public static final String SFSG = "sfsg";
	public static final String SFSQ = "sfsq";
	public static final String SFST = "sfst";
	public static final String SFSW = "sfsw";
	public static final String QQPCJE = "qqpcje";
	public static final String SCBC = "scbc";
	public static final String HPJE = "hpje";

	protected void initDao() {
		// do nothing
	}

	public void save(DsrJb transientInstance) {
		log.debug("saving DsrJb instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DsrJb persistentInstance) {
		log.debug("deleting DsrJb instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DsrJb findById(DsrJbId id) {
		log.debug("getting DsrJb instance with id: " + id);
		try {
			DsrJb instance = (DsrJb) getHibernateTemplate().get(
					"software.tjspxt.data.dataobject.DsrJb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DsrJb> findByExample(DsrJb instance) {
		log.debug("finding DsrJb instance by example");
		try {
			List<DsrJb> results = (List<DsrJb>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DsrJb instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DsrJb as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DsrJb> findByDsrssdw(Object dsrssdw) {
		return findByProperty(DSRSSDW, dsrssdw);
	}

	public List<DsrJb> findByDsrlb(Object dsrlb) {
		return findByProperty(DSRLB, dsrlb);
	}

	public List<DsrJb> findByDsrjc(Object dsrjc) {
		return findByProperty(DSRJC, dsrjc);
	}

	public List<DsrJb> findBySfssdbr(Object sfssdbr) {
		return findByProperty(SFSSDBR, sfssdbr);
	}

	public List<DsrJb> findByDsrbgfs(Object dsrbgfs) {
		return findByProperty(DSRBGFS, dsrbgfs);
	}

	public List<DsrJb> findByDsrbgyy(Object dsrbgyy) {
		return findByProperty(DSRBGYY, dsrbgyy);
	}

	public List<DsrJb> findBySfsa(Object sfsa) {
		return findByProperty(SFSA, sfsa);
	}

	public List<DsrJb> findBySfsg(Object sfsg) {
		return findByProperty(SFSG, sfsg);
	}

	public List<DsrJb> findBySfsq(Object sfsq) {
		return findByProperty(SFSQ, sfsq);
	}

	public List<DsrJb> findBySfst(Object sfst) {
		return findByProperty(SFST, sfst);
	}

	public List<DsrJb> findBySfsw(Object sfsw) {
		return findByProperty(SFSW, sfsw);
	}

	public List<DsrJb> findByQqpcje(Object qqpcje) {
		return findByProperty(QQPCJE, qqpcje);
	}

	public List<DsrJb> findByScbc(Object scbc) {
		return findByProperty(SCBC, scbc);
	}

	public List<DsrJb> findByHpje(Object hpje) {
		return findByProperty(HPJE, hpje);
	}

	public List findAll() {
		log.debug("finding all DsrJb instances");
		try {
			String queryString = "from DsrJb";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DsrJb merge(DsrJb detachedInstance) {
		log.debug("merging DsrJb instance");
		try {
			DsrJb result = (DsrJb) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DsrJb instance) {
		log.debug("attaching dirty DsrJb instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DsrJb instance) {
		log.debug("attaching clean DsrJb instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public long getMaxDsrjbbh(long ajxh) {
		String hql = "select max(dsrbh) from DsrJb where ajxh="+ajxh;
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);

		int maxbh = 0;
		if (query.uniqueResult() != null)
			maxbh = (Integer) query.uniqueResult();

		
		return maxbh;
	}

	public static DsrJbDao getFromApplicationContext(ApplicationContext ctx) {
		return (DsrJbDao) ctx.getBean("DsrJbDAO");
	}
	

	/**
	 * ͨ�������Լ������˵����ϵ�λ�õ���������Ϣ
	 * @param ajxh �������
	 * @return ��������Ϣ�б� 
	 */
	public List<DsrJb> getDsrbyAjxhAndDsrssdw(int ajxh)
	{
		String hql = "from DsrJb where ajxh = " + ajxh + " and (dsrssdw in ('12', '16', '22', '27'))";
		try {
			log.debug("getDsrbyAjxh successful");
			return (List<DsrJb>) getHibernateTemplate().find(hql);
		} catch (RuntimeException re) {
			log.error("getDsrbyAjxh failed", re);
			throw re;
		}
	}
	
	public List<DsrJb> getDsrByAjxh(int ajxh)
	{
		String hql = "from DsrJb where ajxh = " + ajxh + " ORDER BY dsrssdw, dsrbh";
		try {
			log.debug("getDsrbyAjxh successful");
			return (List<DsrJb>) getHibernateTemplate().find(hql);
		} catch (RuntimeException re) {
			log.error("getDsrbyAjxh failed", re);
			throw re;
		}
	}
	public DsrJb getDsrByAjxhAndJc(int ajxh,String dsrjc){
		String hql = "from DsrJb where ajxh = " + ajxh + " and dsrjc = '"+dsrjc+"'";
		try{
			List<DsrJb> dsrList = (List<DsrJb>) getHibernateTemplate().find(hql);
			if(dsrList!=null && dsrList.size()>0)
				return dsrList.get(0);
			else
				return null;
		}catch (RuntimeException re) {
			log.error("getDsrByAjxhAndJc failed", re);
			throw re;
		}
	}
}