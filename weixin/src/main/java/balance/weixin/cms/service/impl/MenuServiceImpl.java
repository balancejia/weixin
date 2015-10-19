package balance.weixin.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.smart4j.framework.dao.DatabaseHelper;
import org.smart4j.framework.dao.SqlHelper;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;

import balance.weixin.cms.bean.MenuBean;
import balance.weixin.cms.entity.CmsMenu;
import balance.weixin.cms.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	private static final String subMenuSql = SqlHelper.getSql("SELECT_SUBMENU");

	public List<MenuBean> getRootDisplayableMenu() {
		List<CmsMenu> list = DataSet.selectListWithConditionAndSort(
				CmsMenu.class, "display='1' and level=1", "seq_num asc", null);

		List<MenuBean> beans = new ArrayList<MenuBean>();
		if (list != null) {
			for (CmsMenu menu : list) {
				List<CmsMenu> subList = getSubMenu(menu.getId());
				MenuBean bean = new MenuBean(menu, subList, subList.size() > 0);
				beans.add(bean);
			}
		}

		return beans;

	}

	public List<CmsMenu> getSubMenu(long menuId) {

		List<CmsMenu> list = DatabaseHelper.queryEntityList(CmsMenu.class,
				subMenuSql, menuId);
		return list;
	}

	@Override
	public CmsMenu getMenu(long menuId) {

		return DataSet.select(CmsMenu.class, "id=?", menuId);
	}

	@Override
	public List<CmsMenu> getRootMenu() {
		List<CmsMenu> list = DataSet.selectListWithConditionAndSort(
				CmsMenu.class, "level=1", "seq_num asc", null);

		return list;
	}
}
