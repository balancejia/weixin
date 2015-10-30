/**
 *
 */
package balance.weixin.wechat.service;


/**
 * @author balancejia
 *
 */
public interface WechatUserService {
	public boolean subscribe(String openId);

	public boolean unsunscribe(String openId);
}
