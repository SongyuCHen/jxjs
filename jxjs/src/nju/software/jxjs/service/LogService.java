package nju.software.jxjs.service;

import java.util.List;

import nju.software.jxjs.dao.TLogDao;
import nju.software.jxjs.model.TLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;

@Service
public class LogService {
	@Autowired
	private TLogDao logDao;
	@Cacheable(cacheName="logCache")
	public List<TLog> getLogByDateAndType(String begin,String end,String type){
		return logDao.getLogByDateAndType(begin, end, type);
	}

}
