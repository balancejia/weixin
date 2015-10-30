/**
 *
 */
package balance.weixin.wechat.service.impl;

import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;

import balance.weixin.wechat.entity.WechatConfig;
import balance.weixin.wechat.service.WechatConfigService;

/**
 * @author balancejia
 *
 */
@Service
public class WechatConfigServiceImpl implements WechatConfigService {

	@Override
	public String getVal(String key) {
		WechatConfig config = DataSet.select(WechatConfig.class, "key_ = ?", key);
		return config.getVal();
	}

}
