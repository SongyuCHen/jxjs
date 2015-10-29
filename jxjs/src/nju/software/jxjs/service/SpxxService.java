package nju.software.jxjs.service;

import java.util.List;

import nju.software.jxjs.dao.SpxxDao;
import nju.software.jxjs.model.TSpxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpxxService {
	@Autowired
	private SpxxDao spxxDao;
	public List<TSpxx> getSPxxByJxjsbh(int jxjsbh){
		return spxxDao.getSPxxByJxjsbh(jxjsbh);
	}
	
	
	
	public TSpxx add(TSpxx spxx){
		int spxxbh = spxxDao.getMaxBh();
		spxxbh ++;
		spxx.setSpxxbh(spxxbh);
		spxxDao.save(spxx);
		return spxx;
	}
	
	public void update(TSpxx spxx){
		spxxDao.update(spxx);
	}
	
	public void delete(TSpxx spxx){
		spxxDao.delete(spxx);
	}

}
