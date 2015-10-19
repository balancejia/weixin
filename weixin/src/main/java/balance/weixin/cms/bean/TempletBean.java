package balance.weixin.cms.bean;

import java.util.List;

import balance.weixin.cms.entity.CmsTemplet;
import balance.weixin.cms.entity.CmsTempletField;

public class TempletBean {

	private CmsTemplet templet;

	private List<CmsTempletField> fields;

	public CmsTemplet getTemplet() {
		return templet;
	}

	public void setTemplet(CmsTemplet templet) {
		this.templet = templet;
	}

	public List<CmsTempletField> getFields() {
		return fields;
	}

	public void setFields(List<CmsTempletField> fields) {
		this.fields = fields;
	}




}
