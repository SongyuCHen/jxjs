package nju.software.jxjs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import nju.software.jxjs.model.PubXtglYhb;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * PubXtglYhb entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see software.tjspxt.data.dataobject.PubXtglYhb
 * @author MyEclipse Persistence Tools
 */
@Repository
public class XtglYhbDao extends BaseDao {
	private static final Logger log = LoggerFactory
			.getLogger(XtglYhbDao.class);
	// property constants
	public static final String YHDM = "yhdm";
	public static final String YHMC = "yhmc";
	public static final String YHKL = "yhkl";
	public static final String YHBM = "yhbm";
	public static final String KLTS = "klts";
	public static final String KLDA = "klda";
	public static final String YHSF = "yhsf";
	public static final String QJYY = "qjyy";
	public static final String GRNZB = "grnzb";
	public static final String QTNZB = "qtnzb";
	public static final String GRBAJS = "grbajs";
	public static final String PHONE = "phone";
	public static final String XFQX = "xfqx";
	public static final String SSFWZXQX = "ssfwzxqx";
	public static final String JBXXJ_CODE = "jbxxjCode";
	public static final String FAZT = "fazt";
	public static final String FASL = "fasl";
	public static final String FYBH = "fybh";
	public static final String YHZT = "yhzt";

	protected void initDao() {
		// do nothing
	}


	public void save(PubXtglYhb transientInstance) {
		log.debug("saving PubXtglYhb instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PubXtglYhb persistentInstance) {
		log.debug("deleting PubXtglYhb instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PubXtglYhb findById(java.lang.Integer id) {
		log.debug("getting PubXtglYhb instance with id: " + id);
		try {
			PubXtglYhb instance = (PubXtglYhb) getHibernateTemplate().get(
					"software.tjspxt.data.dataobject.PubXtglYhb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PubXtglYhb> findByExample(PubXtglYhb instance) {
		log.debug("finding PubXtglYhb instance by example");
		try {
			List<PubXtglYhb> results = (List<PubXtglYhb>) getHibernateTemplate()
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
		log.debug("finding PubXtglYhb instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PubXtglYhb as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PubXtglYhb> findByYhdm(Object yhdm) {
		return findByProperty(YHDM, yhdm);
	}

	public List<PubXtglYhb> findByYhmc(Object yhmc) {
		return findByProperty(YHMC, yhmc);
	}

	public List<PubXtglYhb> findByYhkl(Object yhkl) {
		return findByProperty(YHKL, yhkl);
	}

	public List<PubXtglYhb> findByYhbm(Object yhbm) {
		return findByProperty(YHBM, yhbm);
	}

	public List<PubXtglYhb> findByKlts(Object klts) {
		return findByProperty(KLTS, klts);
	}

	public List<PubXtglYhb> findByKlda(Object klda) {
		return findByProperty(KLDA, klda);
	}

	public List<PubXtglYhb> findByYhsf(Object yhsf) {
		return findByProperty(YHSF, yhsf);
	}

	public List<PubXtglYhb> findByQjyy(Object qjyy) {
		return findByProperty(QJYY, qjyy);
	}

	public List<PubXtglYhb> findByGrnzb(Object grnzb) {
		return findByProperty(GRNZB, grnzb);
	}

	public List<PubXtglYhb> findByQtnzb(Object qtnzb) {
		return findByProperty(QTNZB, qtnzb);
	}

	public List<PubXtglYhb> findByGrbajs(Object grbajs) {
		return findByProperty(GRBAJS, grbajs);
	}

	public List<PubXtglYhb> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<PubXtglYhb> findByXfqx(Object xfqx) {
		return findByProperty(XFQX, xfqx);
	}

	public List<PubXtglYhb> findBySsfwzxqx(Object ssfwzxqx) {
		return findByProperty(SSFWZXQX, ssfwzxqx);
	}

	public List<PubXtglYhb> findByJbxxjCode(Object jbxxjCode) {
		return findByProperty(JBXXJ_CODE, jbxxjCode);
	}

	public List<PubXtglYhb> findByFazt(Object fazt) {
		return findByProperty(FAZT, fazt);
	}

	public List<PubXtglYhb> findByFasl(Object fasl) {
		return findByProperty(FASL, fasl);
	}

	public List<PubXtglYhb> findByFybh(Object fybh) {
		return findByProperty(FYBH, fybh);
	}

	public List<PubXtglYhb> findByYhzt(Object yhzt) {
		return findByProperty(YHZT, yhzt);
	}

	public List findAll() {
		log.debug("finding all PubXtglYhb instances");
		try {
			String queryString = "from PubXtglYhb";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PubXtglYhb merge(PubXtglYhb detachedInstance) {
		log.debug("merging PubXtglYhb instance");
		try {
			PubXtglYhb result = (PubXtglYhb) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PubXtglYhb instance) {
		log.debug("attaching dirty PubXtglYhb instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PubXtglYhb instance) {
		log.debug("attaching clean PubXtglYhb instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PubXtglYhb> getXtyhList(long fybh, String yhdm, String yhmc,
			String yhbm, String yhsf, String yhzt) {
		String hql = "from PubXtglYhb where fybh=" + fybh;
		if (yhdm != null) {
			hql += " and yhdm like '%" + yhdm + "%'";
		}
		if (yhmc != null) {
			hql += " and yhmc like '%" + yhmc + "%'";
		}
		if (!yhbm.equals("全部")) {
			hql += " and yhbm = " + Long.parseLong(yhbm);
		}
		if (!yhsf.equals("全部")) {
			hql += " and yhsf = '" + yhsf + "'";
		}
		if (!yhzt.equals("全部")) {
			hql += " and yhzt=" + (yhzt.equals("true") ? 1 : 0);
		}

		if (log.isInfoEnabled()) {
			log.info("getXtyhList(long,String,String,String,String,String) by sql: "
					+ hql);
		}
		return (List<PubXtglYhb>) getHibernateTemplate().find(hql);
	}
	
	public boolean getXtyhNumberbyBm(long yhbm){
		String hql = "select count(*) from PubXtglYhb where yhbm = " + yhbm;
		
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);

		long count = 0;
		if (query.uniqueResult() != null)
			count = (Long) query.uniqueResult();

		return count > 0 ? true : false;	
	}
	
	public long getMaxYhbh() {
		String hql = "select max(yhbh) from PubXtglYhb";

		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);

		long maxbh = 0;
		if (query.uniqueResult() != null)
			maxbh = (Long) query.uniqueResult();

		return maxbh;
	}
	
	public PubXtglYhb getPubXtglYhbByYhdm(String yhdm) {
		String hql = "from PubXtglYhb p where p.yhdm=?";
		List<PubXtglYhb> PubXtglYhbs = (List<PubXtglYhb>) getHibernateTemplate().find(hql, yhdm);
		if (null == PubXtglYhbs) 
			PubXtglYhbs = new ArrayList<PubXtglYhb>();
		return PubXtglYhbs.size() == 0 ? null : PubXtglYhbs.get(0);
	}
	
	public PubXtglYhb getPubXtglYhbByYhmc(String yhmc) {
		String hql = "from PubXtglYhb where yhdm=?";
		List<PubXtglYhb> PubXtglYhbs = (List<PubXtglYhb>) getHibernateTemplate().find(hql, yhmc);
		if (null == PubXtglYhbs) 
			PubXtglYhbs = new ArrayList<PubXtglYhb>();
		return PubXtglYhbs.size() == 0 ? null : PubXtglYhbs.get(0);
	}

	public static XtglYhbDao getFromApplicationContext(ApplicationContext ctx) {
		return (XtglYhbDao) ctx.getBean("PubXtglYhbDAO");
	}
}