package balance.weixin.cms.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.smart4j.framework.ioc.BeanHelper;

import balance.weixin.cms.bean.MenuBean;
import balance.weixin.cms.entity.CmsMenu;
import balance.weixin.cms.service.impl.MenuServiceImpl;

public class MenuServiceTest {

	 private MenuService service = BeanHelper.getBean(MenuServiceImpl.class);

	@Test
	public void testGetRootDisplayableMenu() {
		List<MenuBean> list = service.getRootDisplayableMenu();
		 Assert.assertEquals(list.size(), 8);
	}

	@Test
	public void testGetSubMenu(){
		List<CmsMenu> list=service.getSubMenu(3);
		 Assert.assertEquals(list.size(), 7);
	}

}
