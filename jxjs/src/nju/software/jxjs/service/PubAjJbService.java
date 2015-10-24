package nju.software.jxjs.service;

import nju.software.jxjs.dao.PubAjJbDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubAjJbService {

	@Autowired
	private PubAjJbDao ajDao;
	public String generateAh(){
		return "";
	}
}
