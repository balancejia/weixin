/**
 *
 */
package balance.weixin.wechat.entity;

import java.util.Date;

import org.smart4j.framework.orm.annotation.Entity;

/**
 * @author balancejia
 *
 */
@Entity
public class WechatUser {

	private long id;

	private String openId;

	private Date subscribeTime;

	private Date unsubscribeTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public Date getUnsubscribeTime() {
		return unsubscribeTime;
	}

	public void setUnsubscribeTime(Date unsubscribeTime) {
		this.unsubscribeTime = unsubscribeTime;
	}

}
