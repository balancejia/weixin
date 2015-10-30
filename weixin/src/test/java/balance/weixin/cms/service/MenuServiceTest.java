package balance.weixin.cms.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.smart4j.framework.ioc.BeanHelper;

import balance.weixin.cms.bean.MenuBean;
import balance.weixin.cms.entity.CmsMenu;
import balance.weixin.wechat.service.WechatConfigService;
import balance.weixin.wechat.service.impl.WechatConfigServiceImpl;

public class MenuServiceTest {

	 private WechatConfigService service = BeanHelper.getBean(WechatConfigServiceImpl.class);

	@Test
	public void testGetRootDisplayableMenu() {
		String c = service.getVal("subscribe");
		System.out.println(c);
	}


	//@Test
	public void testGetSubMenu(){

	}

}
