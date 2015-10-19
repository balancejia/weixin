package balance.weixin.cms.entity;

import org.smart4j.framework.orm.annotation.Entity;

@Entity
public class CmsTempletField {
	private long id;
	private long templetId;
	private String name;
	private String key;
	private String type;
	private String field;
	private String seqNum;
	private String value;


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTempletId() {
		return templetId;
	}

	public void setTempletId(long templetId) {
		this.templetId = templetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

}
