package nju.software.jxjs.service;

import java.util.List;

import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.model.PubDmb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmbService {

	@Autowired
	XtglDmbDao dmbDao;
	public List<PubDmb> getDmbByLbbh(String lbbh){
		return dmbDao.getDmbByLbbh(lbbh);
	}
	public PubDmb getDmbByLbbhAndDmms(String lbbh,String dmms){
		return dmbDao.getDmbByLbbhAndDmms(lbbh, dmms);
	}
	public PubDmb getDmbByLbbhAndDmbh(String lbbh,String dmbh){
		return dmbDao.getDmbByLbbhAndDmbh(lbbh, dmbh);
	}
}
