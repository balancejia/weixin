package balance.weixin.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.ioc.BeanHelper;
import org.smart4j.framework.mvc.UploadHelper;
import org.smart4j.framework.mvc.bean.Multipart;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.framework.tx.annotation.Transaction;
import org.smart4j.framework.util.ObjectUtil;

import balance.weixin.Tool;
import balance.weixin.cms.bean.TempletBean;
import balance.weixin.cms.entity.CmsContent;
import balance.weixin.cms.entity.CmsTempletField;
import balance.weixin.cms.service.ContentService;
import balance.weixin.cms.service.TempletService;

@Service
public class ContentServiceImpl implements ContentService {

	@Override
	public List<Map<String, Object>> getContentList(long menuId) {

		List<CmsContent> contentList = DataSet.selectListWithCondition(CmsContent.class, "menu_id=?", menuId);

		return obj2Map_list(contentList);
	}

	private List<Map<String, Object>> obj2Map_list(List<CmsContent> contentList) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (contentList != null) {
			for (CmsContent content : contentList) {
				list.add(obj2Map(content));
			}
		}

		return list;
	}

	private Map<String, Object> obj2Map(CmsContent content) {
		Map<String, Object> contentMap = ObjectUtil.getFieldMap(content);
		Map<String, Object> item = new LinkedHashMap<String, Object>();

		long templetId = content.getTempletId();

		item.put("id", content.getId());
		item.put("menuId", content.getMenuId());
		item.put("templetId", templetId);
		item.put("createTime", content.getCreateTime());
		item.put("updateTime", content.getUpdateTime());
		item.put("isAd", content.getIsAd());

		TempletService templetService = BeanHelper.getBean(TempletServiceImpl.class);

		TempletBean templetBean = templetService.getTemplet(templetId);

		List<CmsTempletField> fields = templetBean.getFields();

		for (CmsTempletField field : fields) {
			String key = field.getKey();
			String fd = field.getField();
			item.put(key, contentMap.get(fd));
		}
		return item;
	}

	@Override
	@Transaction
	public boolean create(Map<String, Object> fieldMap, Multipart multipart) {
		return create_update(null, fieldMap, multipart);
	}

	@Override
	public List<Map<String, Object>> getActContents() {
		List<CmsContent> contentList = DataSet.selectListWithConditionAndSort(CmsContent.class, "is_ad=?",
				"update_time desc", "1");
		if (contentList.size() > 4) {
			contentList = contentList.subList(0, 4);
		}

		return obj2Map_list(contentList);
	}

	@Override
	public Map<String, Object> getContent(long id) {
		CmsContent content = DataSet.select(CmsContent.class, "id=?", id);
		return obj2Map(content);
	}

	@Override
	public Pager<Map<String, Object>> getContentPager(int pageNumber, int pageSize, long menuId) {
		long count = DataSet.selectCount(CmsContent.class, "menu_id=?", menuId);

		List<CmsContent> contentList = DataSet.selectListForPager(pageNumber, pageSize, CmsContent.class, "menu_id=?",
				"id desc", menuId);

		List<Map<String, Object>> list = obj2Map_list(contentList);

		return new Pager<Map<String, Object>>(pageNumber, pageSize, count, list);
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(long id, Map<String, Object> fieldMap, Multipart multipart) {
		return create_update(id, fieldMap, multipart);
	}

	private boolean create_update(Long id, Map<String, Object> fieldMap, Multipart multipart) {

		boolean hasFile = false;
		if (multipart != null) {
			String fileName = multipart.getFileName();
			if (fileName != null && !fileName.trim().equals("")) {
				fieldMap.put("image", fileName);
				hasFile = true;
			}else{
				fieldMap.put("image", null);
			}
		}else{
			fieldMap.put("image", null);
		}

		long templetId = Long.parseLong((String) fieldMap.get("templetId"));
		long menuId = Long.parseLong((String) fieldMap.get("menuId"));

		TempletService templetService = BeanHelper.getBean(TempletServiceImpl.class);
		TempletBean templet = templetService.getTemplet(templetId);

		List<CmsTempletField> fields = templet.getFields();

		Map<String, Object> contentMap = new LinkedHashMap<String, Object>();

		contentMap.put("menuId", menuId);
		contentMap.put("templetId", templetId);
		contentMap.put("updateTime", new Date());
		contentMap.put("isAd", fieldMap.get("isAd"));

		for (CmsTempletField field : fields) {
			String fieldId = field.getField();
			String key = field.getKey();
			Object val = fieldMap.get(key);
			if (val != null)
				contentMap.put(fieldId, val);
		}

		boolean result = false;
		if (id != null) {
			result = DataSet.update(CmsContent.class, contentMap, "id = ?", id);
		} else {
			contentMap.put("createTime", new Date());
			result = DataSet.insert(CmsContent.class, contentMap);
		}

		if (result && hasFile) {
			UploadHelper.uploadFile(Tool.getBasePath(), multipart);
		}
		return result;

	}
}
