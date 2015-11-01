package nju.software.jxjs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.DsrGr;
import nju.software.jxjs.model.DsrGrId;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;



/**
 * A data access object (DAO) providing persistence and search support for
 * DsrGr entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see software.tjspxt.data.dataobject.DsrGr
 * @author MyEclipse Persistence Tools
 */
@Repository
public class DsrGrDao extends BaseDao {
	private static final Logger log = LoggerFactory.getLogger(DsrGrDao.class);
	// property constants
	public static final String XM = "xm";
	public static final String XB = "xb";
	public static final String MZ = "mz";
	public static final String JG = "jg";
	public static final String ZY = "zy";
	public static final String ZW = "zw";
	public static final String WHCD = "whcd";
	public static final String GZDW = "gzdw";
	public static final String ZZMM = "zzmm";
	public static final String JB = "jb";
	public static final String SF = "sf";
	public static final String HYQK = "hyqk";
	public static final String JTQK = "jtqk";
	public static final String JKQK = "jkqk";
	public static final String SSGJ = "ssgj";
	public static final String SFZHM = "sfzhm";
	public static final String YB = "yb";
	public static final String DH = "dh";
	public static final String DZ = "dz";
	public static final String QRJG = "qrjg";
	public static final String QRGC = "qrgc";
	public static final String ZZD = "zzd";
	public static final String ZWZY = "zwzy";
	public static final String ZJLB = "zjlb";

	protected void initDao() {
		// do nothing
	}

	public void save(DsrGr transientInstance) {
		log.debug("saving DsrGr instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DsrGr persistentInstance) {
		log.debug("deleting DsrGr instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DsrGr findById(DsrGrId id) {
		log.debug("getting DsrGr instance with id: " + id);
		try {
			DsrGr instance = (DsrGr) getHibernateTemplate().get(
					"software.tjspxt.data.dataobject.DsrGr", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public DsrGr getDsrgrByAjxhAndXm(int ajxh,String xm){
		String hql = "from DsrGr gr where gr.ajxh=? and gr.xm=?";
		List<DsrGr> grList = (List<DsrGr>) getHibernateTemplate().find(hql, new Object[]{ajxh,xm});
		if(grList!=null && grList.size()>0)
			return grList.get(0);
		else
			return null;
	}

	public List<DsrGr> findByExample(DsrGr instance) {
		log.debug("finding DsrGr instance by example");
		try {
			List<DsrGr> results = (List<DsrGr>) getHibernateTemplate()
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
		log.debug("finding DsrGr instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DsrGr as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DsrGr> findByXm(Object xm) {
		return findByProperty(XM, xm);
	}

	public List<DsrGr> findByXb(Object xb) {
		return findByProperty(XB, xb);
	}

	public List<DsrGr> findByMz(Object mz) {
		return findByProperty(MZ, mz);
	}

	public List<DsrGr> findByJg(Object jg) {
		return findByProperty(JG, jg);
	}

	public List<DsrGr> findByZy(Object zy) {
		return findByProperty(ZY, zy);
	}

	public List<DsrGr> findByZw(Object zw) {
		return findByProperty(ZW, zw);
	}

	public List<DsrGr> findByWhcd(Object whcd) {
		return findByProperty(WHCD, whcd);
	}

	public List<DsrGr> findByGzdw(Object gzdw) {
		return findByProperty(GZDW, gzdw);
	}

	public List<DsrGr> findByZzmm(Object zzmm) {
		return findByProperty(ZZMM, zzmm);
	}

	public List<DsrGr> findByJb(Object jb) {
		return findByProperty(JB, jb);
	}

	public List<DsrGr> findBySf(Object sf) {
		return findByProperty(SF, sf);
	}

	public List<DsrGr> findByHyqk(Object hyqk) {
		return findByProperty(HYQK, hyqk);
	}

	public List<DsrGr> findByJtqk(Object jtqk) {
		return findByProperty(JTQK, jtqk);
	}

	public List<DsrGr> findByJkqk(Object jkqk) {
		return findByProperty(JKQK, jkqk);
	}

	public List<DsrGr> findBySsgj(Object ssgj) {
		return findByProperty(SSGJ, ssgj);
	}

	public List<DsrGr> findBySfzhm(Object sfzhm) {
		return findByProperty(SFZHM, sfzhm);
	}

	public List<DsrGr> findByYb(Object yb) {
		return findByProperty(YB, yb);
	}

	public List<DsrGr> findByDh(Object dh) {
		return findByProperty(DH, dh);
	}

	public List<DsrGr> findByDz(Object dz) {
		return findByProperty(DZ, dz);
	}

	public List<DsrGr> findByQrjg(Object qrjg) {
		return findByProperty(QRJG, qrjg);
	}

	public List<DsrGr> findByQrgc(Object qrgc) {
		return findByProperty(QRGC, qrgc);
	}

	public List<DsrGr> findByZzd(Object zzd) {
		return findByProperty(ZZD, zzd);
	}

	public List<DsrGr> findByZwzy(Object zwzy) {
		return findByProperty(ZWZY, zwzy);
	}

	public List<DsrGr> findByZjlb(Object zjlb) {
		return findByProperty(ZJLB, zjlb);
	}

	public List findAll() {
		log.debug("finding all DsrGr instances");
		try {
			String queryString = "from DsrGr";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DsrGr merge(DsrGr detachedInstance) {
		log.debug("merging DsrGr instance");
		try {
			DsrGr result = (DsrGr) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DsrGr instance) {
		log.debug("attaching dirty DsrGr instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DsrGr instance) {
		log.debug("attaching clean DsrGr instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DsrGrDao getFromApplicationContext(ApplicationContext ctx) {
		return (DsrGrDao) ctx.getBean("DsrGrDAO");
	}
}