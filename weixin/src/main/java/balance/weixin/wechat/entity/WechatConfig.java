package balance.weixin.wechat.entity;

import org.smart4j.framework.orm.annotation.Entity;

@Entity
public class WechatConfig {

	private long id;
	private String key_;
	private String val;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKey_() {
		return key_;
	}

	public void setKey_(String key) {
		this.key_ = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
