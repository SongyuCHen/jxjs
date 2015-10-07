package nju.software.jxjs.helper;

import java.util.List;

import nju.software.jxjs.model.Menu;

public class MenuWrapper {
	private List<Menu> headerMenus;
	private List<Menu> subMenus;
	private Menu currentHeader;
	private Menu currentSub;
	public List<Menu> getHeaderMenus() {
		return headerMenus;
	}
	public void setHeaderMenus(List<Menu> headerMenus) {
		this.headerMenus = headerMenus;
	}
	public List<Menu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}
	public Menu getCurrentHeader() {
		return currentHeader;
	}
	public void setCurrentHeader(Menu currentHeader) {
		this.currentHeader = currentHeader;
	}
	public Menu getCurrentSub() {
		return currentSub;
	}
	public void setCurrentSub(Menu currentSub) {
		this.currentSub = currentSub;
	}
	
}
