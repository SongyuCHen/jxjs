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

import org.springframework.cache.annotation.Cacheable;

/**
 * 生成menu
 * @author Administrator
 *
 */
@Service
public class MenuService extends BaseService{
	
	@Autowired
	public PropertiesFactoryBean propertiesReader;
	
	/**
	 * 
	 * @param role  角色名
	 * @param currentHeader   当前主菜单
	 * @param currentSub      当前子菜单
	 * @return
	 */
	@Cacheable(value="menuCache")
	public MenuWrapper makeMenu(String role, String currentHeader, String currentSub){
		//System.out.println("###########"+role+" "+currentHeader+" "+currentSub);
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
	@Cacheable(value="menuCache")
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
			Menu hMenu = getMenu(menuStr);
			List<Menu> subs = getSubMenus(role,hMenu.getUniqueName());
			Menu firstSubMenu = null;
			if(subs.size()>0){
				firstSubMenu = subs.get(0);
				hMenu.setUrl(firstSubMenu.getUrl());
			}
			
			menus.add(hMenu);
		}
		
		return menus;
	}
	@Cacheable(value="menuCache")
	private List<Menu> getSubMenus(String role,String currentHeader){
		List<Menu> menus = new ArrayList<Menu>();
		Properties ps = getProperties();
		if(ps==null){
			return menus;
		}
		String menusStr = ps.getProperty(currentHeader+".sub");
		if(menusStr==null||menusStr.length()==0){
			return menus;
		}
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
