package nju.software.jxjs.service;

import java.util.List;

import nju.software.jxjs.dao.JxjsDao;
import nju.software.jxjs.model.TJxjs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DsplbService {
	
	@Autowired
	private JxjsDao jd;
	
	public List<TJxjs> getDsplb(){
		return jd.getJxjsByAjztbh("待审批");
	}

}
