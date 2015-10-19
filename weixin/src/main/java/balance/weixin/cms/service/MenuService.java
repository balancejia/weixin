package balance.weixin.cms.service;

import java.util.List;

import balance.weixin.cms.bean.MenuBean;
import balance.weixin.cms.entity.CmsMenu;

public interface MenuService {

	List<MenuBean> getRootDisplayableMenu();

	List<CmsMenu> getRootMenu();

	List<CmsMenu> getSubMenu(long pId);

	CmsMenu getMenu(long menuId);
}
