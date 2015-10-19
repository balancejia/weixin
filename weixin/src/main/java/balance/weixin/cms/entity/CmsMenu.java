package balance.weixin.cms.entity;

import org.smart4j.framework.orm.annotation.Entity;

@Entity
public class CmsMenu {

	private long id;
	private String name;
	private String code;
	private String display;
	private int level;
	private int seqNum;
	private String isLeaf;
	private String listStyle;
	private String submenuStyle;
	private String image;
	private long templetId;

	public long getTempletId() {
		return templetId;
	}

	public void setTempletId(long templetId) {
		this.templetId = templetId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getListStyle() {
		return listStyle;
	}

	public void setListStyle(String listStyle) {
		this.listStyle = listStyle;
	}

	public String getSubmenuStyle() {
		return submenuStyle;
	}

	public void setSubmenuStyle(String submenuStyle) {
		this.submenuStyle = submenuStyle;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

}
