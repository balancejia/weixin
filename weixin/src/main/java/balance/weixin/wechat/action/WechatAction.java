/**
 *
 */
package balance.weixin.wechat.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Result;
import org.sword.wechat4j.event.EventType;
import org.sword.wechat4j.exception.WeChatException;
import org.sword.wechat4j.menu.Menu;
import org.sword.wechat4j.menu.MenuButton;
import org.sword.wechat4j.menu.MenuManager;

import balance.weixin.wechat.entity.WechatMenu;
import balance.weixin.wechat.service.WechatMenuService;
import balance.weixin.wechat.service.ZiXunWechat;

/**
 * @author balancejia
 *
 */
@Action
public class WechatAction {

	private static final Logger logger = LoggerFactory.getLogger(WechatAction.class);

	@Inject
	private WechatMenuService menuService;

	@Request.Get("/wechat")
	public void get() {
		executePost();
	}

	@Request.Post("/wechat")
	public void post() {
		executePost();
	}

	private void executePost() {
		ZiXunWechat wechat = new ZiXunWechat(DataContext.getRequest());
		String result = wechat.execute();
		write(DataContext.getResponse(), result);
	}

	private void write(HttpServletResponse resp, String result) {
		try {
			ServletOutputStream out = resp.getOutputStream();
			out.write(result.getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.error("在响应中写数据出错！", e);
			throw new RuntimeException(e);
		}
	}

	// @HasRoles("admin")
	@Request.Get("/wechat/synmenu")
	public Result synMenu() {
		List<WechatMenu> menus = menuService.getMenus("button");
		Menu menu = new Menu();

		ArrayList<MenuButton> buttons = new ArrayList<MenuButton>();

		for (WechatMenu m : menus) {
			MenuButton button = newButton(m);
			List<MenuButton> subButtons = new ArrayList<MenuButton>();

			List<WechatMenu> subMenus = menuService.getSubmenus(m.getPid());

			if (subMenus != null) {
				for (WechatMenu subM : subMenus) {
					MenuButton subButton = newButton(subM);
					subButtons.add(subButton);
				}
			}

			button.setSubButton(subButtons);

			buttons.add(button);

		}
		menu.setButton(buttons);

		MenuManager menuMgr = new MenuManager();

		try {
			menuMgr.create(menu);
		} catch (WeChatException e) {
			e.printStackTrace();
			return new Result(false);
		}
		return new Result(true);
	}

	private MenuButton newButton(WechatMenu m) {
		MenuButton button = new MenuButton();
		button.setKey(m.getKey());
		button.setMediaId(m.getMediaId());
		button.setName(m.getName());
		button.setUrl(m.getUrl());
		String type = m.getType();

		if (type.equals("click"))
			button.setType(EventType.click);
		else if (type.equals("view"))
			button.setType(EventType.view);
		return button;
	}

}
