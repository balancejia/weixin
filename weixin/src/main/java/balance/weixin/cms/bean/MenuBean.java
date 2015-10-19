package balance.weixin.cms.bean;

import java.util.List;

import balance.weixin.cms.entity.CmsMenu;

public class MenuBean {

	private CmsMenu menu;
	private List<CmsMenu> subMenuList;
	private boolean hasSubMenu;

	public MenuBean(CmsMenu menu, List<CmsMenu> subMenuList, boolean hasSubMenu) {
		this.menu = menu;
		this.subMenuList = subMenuList;
		this.hasSubMenu = hasSubMenu;
	}

	public CmsMenu getMenu() {
		return menu;
	}

	public void setMenu(CmsMenu menu) {
		this.menu = menu;
	}

	public List<CmsMenu> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<CmsMenu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public boolean isHasSubMenu() {
		return hasSubMenu;
	}

	public void setHasSubMenu(boolean hasSubMenu) {
		this.hasSubMenu = hasSubMenu;
	}

}
