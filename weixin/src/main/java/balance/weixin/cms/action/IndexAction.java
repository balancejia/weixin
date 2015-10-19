package balance.weixin.cms.action;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.View;

import balance.weixin.cms.bean.MenuBean;
import balance.weixin.cms.service.ContentService;
import balance.weixin.cms.service.MenuService;

@Action
public class IndexAction {

	@Inject
	private MenuService menuService;

	@Inject
	private ContentService contentService;

	@Request.Get("/index")
	public View index() {
		List<MenuBean> menuList = menuService.getRootDisplayableMenu();

		List<Map<String, Object>> actContents = contentService.getActContents();
		return new View("weinet/index.jsp").data("menuList1",
				menuList.subList(0, 4)).data("menuList2",
				menuList.subList(4, 8)).data("actContents", actContents);
	}
}
