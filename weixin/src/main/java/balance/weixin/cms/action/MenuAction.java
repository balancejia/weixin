package balance.weixin.cms.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.mvc.bean.View;

import balance.weixin.Constant;
import balance.weixin.cms.entity.CmsMenu;
import balance.weixin.cms.service.ContentService;
import balance.weixin.cms.service.MenuService;

import com.alibaba.fastjson.JSON;

@Action
public class MenuAction {

	@Inject
	private MenuService menuService;

	@Inject
	private ContentService contentService;

	private static int PAGE_SIZE = 2;// 只能偶数，要不然一行两列的显示就不正常了

	@Request.Get("/menu/list/{menuId}")
	public View list(long menuId) {
		CmsMenu menu = menuService.getMenu(menuId);
		String listStyle = menu.getListStyle();

		Pager<Map<String, Object>> pager = contentService.getContentPager(1, PAGE_SIZE, menuId);

		int p = pager.getPageNumber();
		long tp = pager.getTotalPage();

		String next = "end";
		if (p < tp)
			next = "menu/pageList?menuId=" + menuId + "&pageNumber=" + (++p);

		return new View("weinet/" + listStyle).data("list", pager.getRecordList()).data("next", next);
	}

	@Request.Post("/menu/pageList")
	public View listPage(Params params) {
		int pageNumber = params.getInt(Constant.PAGE_NUMBER);

		long menuId = params.getLong("menuId");

		CmsMenu menu = menuService.getMenu(menuId);
		String listStyle = menu.getListStyle();

		Pager<Map<String, Object>> pager = contentService.getContentPager(pageNumber, PAGE_SIZE, menuId);

		int p = pager.getPageNumber();
		long tp = pager.getTotalPage();

		String next = "end";
		if (p < tp)
			next = "menu/pageList?menuId=" + menuId + "&pageNumber=" + (++p);
		return new View("weinet/" + listStyle).data("list", pager.getRecordList()).data("next", next);
	}

	@Request.Get("/menu/submenu/{menuId}")
	public View submenu(long menuId) {
		CmsMenu menu = menuService.getMenu(menuId);

		String submenuStyle = menu.getSubmenuStyle();

		List<CmsMenu> menus = menuService.getSubMenu(menuId);

		return new View("weinet/" + submenuStyle).data("menus", menus);
	}

	@Request.Get("/menu/submenu/json/{menuId}")
	public Result submenuJson(long menuId) {

		List<CmsMenu> menus = menuService.getSubMenu(menuId);

		Result result = new Result(true);
		result.setData(toJson(menus));

		return result;
	}

	@Request.Get("/menu/root")
	public Result rootMenuJson() {
		List<CmsMenu> menuList = menuService.getRootMenu();
		Result result = new Result(true);
		result.setData(toJson(menuList));
		return result;
	}

	public static String toJson(List<CmsMenu> menus) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (CmsMenu menu : menus) {
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("title", menu.getName());
			map.put("type", menu.getIsLeaf().equals("1") ? "item" : "folder");
			Map<String, Object> attr=new LinkedHashMap<String, Object>();
			attr.put("id", menu.getId());
			attr.put("templetId", menu.getTempletId());
			map.put("attr", attr);
			list.add(map);
		}

		String json = JSON.toJSONString(list);

		return json;

	}
}
