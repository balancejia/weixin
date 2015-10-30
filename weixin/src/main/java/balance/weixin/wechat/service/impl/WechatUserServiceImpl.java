/**
 *
 */
package balance.weixin.wechat.service.impl;

import java.util.Date;

import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;

import balance.weixin.wechat.entity.WechatUser;
import balance.weixin.wechat.service.WechatUserService;

/**
 * @author balancejia
 *
 */
@Service
public class WechatUserServiceImpl implements WechatUserService {

	@Override
	public boolean subscribe(WechatUser user) {
		user.setSubscribeTime(new Date());
		return DataSet.insert(user);
	}

	@Override
	public boolean unsunscribe(String openId) {

		WechatUser user = DataSet.select(WechatUser.class, "open_id = ?", openId);

		user.setUnsubscribeTime(new Date());

		return DataSet.update(user);
	}

}
