package balance.weixin.cms.entity;

import org.smart4j.framework.orm.annotation.Entity;

@Entity
public class CmsTemplet {
	private long id;
	private String name;
	private String desc;
	private String templetFile;

	public String getTempletFile() {
		return templetFile;
	}

	public void setTempletFile(String templetFile) {
		this.templetFile = templetFile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
