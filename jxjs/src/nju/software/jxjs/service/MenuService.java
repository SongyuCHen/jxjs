package nju.software.jxjs.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import nju.software.jxjs.helper.MenuWrapper;
import nju.software.jxjs.model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;


@Service
public class MenuService extends BaseService{
	
	@Autowired
	public PropertiesFactoryBean propertiesReader;
	
	
	public MenuWrapper makeMenu(String role, String currentHeader, String currentSub){
		MenuWrapper mw = new MenuWrapper();
		mw.setHeaderMenus(getHeaderMenus(role));
		mw.setSubMenus(getSubMenus(role,currentHeader));
		mw.setCurrentHeader(getMenu(currentHeader));
		mw.setCurrentSub(getMenu(currentSub));	
		return mw;
	}
	
	/**
	 * 获得所有主菜单
	 * @return
	 */
	private List<Menu> getHeaderMenus(String role){
		List<Menu> menus = new ArrayList<Menu>();
		Properties ps = getProperties();
		if(ps==null){
			return menus;
		}
		String menusStr = ps.getProperty(role+".head");
		//logger.info("@@@@@@"+menuStr);
		
		List<String> menuStrList = Arrays.asList(menusStr.split(","));
		for(String menuStr : menuStrList){
			menus.add(getMenu(menuStr));
		}
		
		return menus;
	}
	
	private List<Menu> getSubMenus(String role,String currentHeader){
		List<Menu> menus = new ArrayList<Menu>();
		Properties ps = getProperties();
		if(ps==null){
			return menus;
		}
		String menusStr = ps.getProperty(currentHeader+".sub");
		List<String> menuStrList = Arrays.asList(menusStr.split(","));
		
		String allSubsStr = ps.getProperty(role+".sub");
		List<String> allSubsSet = Arrays.asList(allSubsStr.split(","));
		for(String menuStr : menuStrList){
			if(allSubsSet.contains(menuStr)){
				menus.add(getMenu(menuStr));
			}
		}
		return menus;
	}
	
	private Menu getMenu(String menuName){
		Menu menu = new Menu();
		Properties ps = getProperties();
		if(ps==null){
			return menu;
		}
		menu.setUniqueName(ps.getProperty(menuName+".uniqueName"));
		menu.setUrl(ps.getProperty(menuName+".url"));
		menu.setZh(ps.getProperty(menuName+".zh"));
		return menu;
	}
	
	private Properties getProperties(){
		try {
			Properties ps = propertiesReader.getObject();
			return ps;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			return null;
		}
	}
	
	

}
