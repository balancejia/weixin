package balance.weixin.cms.action;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.smart4j.framework.ioc.BeanHelper;

import balance.weixin.cms.service.MenuService;
import balance.weixin.cms.service.impl.MenuServiceImpl;

public class MenuActionTest {

	private MenuService service = BeanHelper
			.getBean(MenuServiceImpl.class);

	@Test
	public void testSubmenuJson() {

		System.out.println(MenuAction.toJson(service.getRootMenu()));

	}

	@Test
	public void testRootMenuJson() {
		//fail("Not yet implemented");
	}

}
