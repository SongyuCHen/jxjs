package nju.software.jxjs.service;

import java.util.List;

import nju.software.jxjs.dao.TDsrDao;
import nju.software.jxjs.model.TDsr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDsrService{
	@Autowired
	private TDsrDao dsrDao;
	public TDsr getDsrByjxjsbh(int jxjsbh){
		return dsrDao.getDsrByJxjsbh(jxjsbh);
	}

}
