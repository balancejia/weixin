/**
 *
 */
package balance.weixin.wechat.service.impl;

import java.util.List;

import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;

import balance.weixin.wechat.entity.WechatMenu;
import balance.weixin.wechat.service.WechatMenuService;

/**
 * @author balancejia
 *
 */
@Service
public class WechatMenuServiceImpl implements WechatMenuService {

	@Override
	public List<WechatMenu> getMenus(String level) {

		List<WechatMenu> menus = DataSet.selectListWithCondition(WechatMenu.class, "level=?", level);
		return menus;
	}

	public List<WechatMenu> getSubmenus(long pId) {
		List<WechatMenu> menus = DataSet.selectListWithCondition(WechatMenu.class, "pid=?", pId);
		return menus;
	}

}
