package nju.software.jxjs.controller;

import nju.software.jxjs.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xtdj")
public class XtdjController extends BaseController
{
	@Autowired
	private MenuService ms;

}
