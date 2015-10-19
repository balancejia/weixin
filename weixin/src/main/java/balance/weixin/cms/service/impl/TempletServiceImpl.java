package balance.weixin.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;

import balance.weixin.cms.bean.TempletBean;
import balance.weixin.cms.entity.CmsTemplet;
import balance.weixin.cms.entity.CmsTempletField;
import balance.weixin.cms.service.TempletService;

@Service
public class TempletServiceImpl implements TempletService {

	private static Map<String, TempletBean> templetCatch;

	@Override
	public TempletBean getTemplet(long id) {
		CmsTemplet templet = DataSet.select(CmsTemplet.class, "id = ?", id);
		TempletBean templetBean = new TempletBean();
		templetBean.setTemplet(templet);
		List<CmsTempletField> fields = DataSet.selectListWithCondition(
				CmsTempletField.class, "templet_id=?", id);
		templetBean.setFields(fields);
		return templetBean;
	}

}
