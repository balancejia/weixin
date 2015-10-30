/**
 *
 */
package balance.weixin.wechat.service;

import balance.weixin.wechat.entity.WechatUser;

/**
 * @author balancejia
 *
 */
public interface WechatUserService {
	public boolean subscribe(WechatUser user);

	public boolean unsunscribe(String openId);
}
