package nju.software.jxjs.controller;
import java.util.Date;

import nju.software.jxjs.util.DateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class BaseController 
{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		CustomDateEditor dateEditor = new CustomDateEditor(DateUtil.STANDARD_SDF, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
}
