/**
 *
 */
package balance.weixin.wechat.service;

import java.util.List;

import balance.weixin.wechat.entity.WechatMenu;

/**
 * @author balancejia
 *
 */
public interface WechatMenuService {

	public List<WechatMenu> getMenus(String level);

	public List<WechatMenu> getSubmenus(long pId);
}
