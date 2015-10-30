package nju.software.jxjs.service;

import java.util.List;

import nju.software.jxjs.dao.PubLaAyDao;
import nju.software.jxjs.model.PubLaAy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubLaAyService {
	@Autowired
	private PubLaAyDao ayDao;
	public PubLaAy getAyByAjxh(int ajxh){
		List<PubLaAy> ayList = ayDao.getAyByAjxh(ajxh);
		if(ayList!=null && ayList.size()>0)
			return ayList.get(0);
		else
			return null;
	}

}
