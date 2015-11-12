package nju.software.jxjs.service;

import java.util.List;

import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.model.PubDmb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.Cacheable;

@Service
public class DmbService {

	@Autowired
	XtglDmbDao dmbDao;
	@Cacheable(value="dmbCache")
	public List<PubDmb> getDmbByLbbh(String lbbh){
		return dmbDao.getDmbByLbbh(lbbh);
	}
	@Cacheable(value="dmbCache")
	public PubDmb getDmbByLbbhAndDmms(String lbbh,String dmms){
		return dmbDao.getDmbByLbbhAndDmms(lbbh, dmms);
	}
	@Cacheable(value="dmbCache")
	public PubDmb getDmbByLbbhAndDmbh(String lbbh,String dmbh){
		return dmbDao.getDmbByLbbhAndDmbh(lbbh, dmbh);
	}
}
