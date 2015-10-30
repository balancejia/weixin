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
	public boolean subscribe(String openId) {
		WechatUser user = DataSet.select(WechatUser.class, "open_id = ?", openId);
		if (user == null)
			user = new WechatUser();
		int times = user.getTimes_();
		user.setOpenId(openId);
		user.setSubscribeTime(new Date());
		user.setTimes_(++times);

		if (times == 1)
			return DataSet.insert(user);
		else
			return DataSet.update(user);
	}

	@Override
	public boolean unsunscribe(String openId) {

		WechatUser user = DataSet.select(WechatUser.class, "open_id = ?", openId);

		if (user != null) {

			user.setUnsubscribeTime(new Date());

			return DataSet.update(user);
		} else
			return true;
	}

}
