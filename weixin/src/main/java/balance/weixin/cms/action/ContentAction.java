package balance.weixin.cms.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Multipart;
import org.smart4j.framework.mvc.bean.Multiparts;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.mvc.bean.View;
import org.smart4j.plugin.security.annotation.HasRoles;

import balance.weixin.Constant;
import balance.weixin.cms.bean.TempletBean;
import balance.weixin.cms.entity.CmsTempletField;
import balance.weixin.cms.service.ContentService;
import balance.weixin.cms.service.TempletService;

@Action
public class ContentAction {

	private static int PAGE_SIZE = 10;// 只能偶数，要不然一行两列的显示就不正常了

	@Inject
	private ContentService contentService;

	@Inject
	private TempletService templetService;

	@HasRoles("admin")
	@Request.Get("/content/manage")
	public View manage() {
		return new View("admin/content_manage.jsp");
	}

	@Request.Get("/content/detail/{id}")
	public View detail(long id) {
		Map<String, Object> contentMap = contentService.getContent(id);

		long templetId = (Long) contentMap.get("templetId");

		TempletBean temple = templetService.getTemplet(templetId);

		String templeFile = temple.getTemplet().getTempletFile();

		return new View("weinet/" + templeFile).data("contentMap", contentMap);
	}

	@HasRoles("admin")
	@Request.Get("/content/list/{menuId}/{templetId}/{pn}")
	public View list(long menuId, long templetId, int pn) {
		if (pn <= 0)
			pn = 1;
		Pager<Map<String, Object>> pager = contentService.getContentPager(pn, PAGE_SIZE, menuId);
		int p = pager.getPageNumber();
		long tp = pager.getTotalPage();

		String preDisable = "";
		String nextDisable = "";

		if (p == 1)
			preDisable = "disabled=\"disabled\"";
		if (p == tp)
			nextDisable = "disabled=\"disabled\"";
		return new View("admin/content_list.jsp").data("list", pager.getRecordList()).data("menuId", menuId)
				.data("templetId", templetId).data("preDisable", preDisable).data("nextDisable", nextDisable)
				.data("p", p).data("tp", tp);
	}

	@HasRoles("admin")
	@Request.Post("/content/search")
	public View search(Params params) {
		int pageNumber = params.getInt(Constant.PAGE_NUMBER);
		int pageSize = params.getInt(Constant.PAGE_SIZE);
		String name = params.getString("name");

		return new View("content_list.jsp");// data("productBeanPager",
											// productBeanPager);
	}

	@HasRoles("admin")
	@Request.Get("/content/create/{templetId}/{menuId}")
	public View create(long templetId, long menuId) {
		TempletBean temple = templetService.getTemplet(templetId);
		List<CmsTempletField> fields = temple.getFields();
		return new View("admin/content_create.jsp").data("fields", fields).data("menuId", menuId)
				.data("templetId", templetId);
	}

	@HasRoles("admin")
	@Request.Post("/content/create")
	public Result create(Params params, Multiparts multiparts) {
		Map<String, Object> fieldMap = params.getFieldMap();
		Multipart multipart = multiparts.getOne();
		boolean success = contentService.create(fieldMap, multipart);

		long templetId = Long.parseLong((String) fieldMap.get("templetId"));
		long menuId = Long.parseLong((String) fieldMap.get("menuId"));
		Result result = new Result(success);
		Map<String, String> data = new HashMap<String, String>();
		data.put("menuId", menuId + "");
		data.put("templetId", templetId + "");
		result.setData(data);
		return result;
	}

	@HasRoles("admin")
	@Request.Delete("/content/delete/{id}")
	public Result delete(long id) {
		boolean success = contentService.delete(id);
		return new Result(success);
	}

	@HasRoles("admin")
	@Request.Get("/content/view/{id}")
	public View view(long id) {
		Map<String, Object> content = contentService.getContent(id);
		return new View("content_view.jsp").data("content", content);
	}

	@HasRoles("admin")
	@Request.Get("/content/edit/{id}")
	public View edit(long id) {

		Map<String, Object> content = contentService.getContent(id);

		long templetId = (Long) content.get("templetId");
		long menuId = (Long) content.get("menuId");

		TempletBean temple = templetService.getTemplet(templetId);
		List<CmsTempletField> fields = temple.getFields();

		for (CmsTempletField field : fields) {
			String value = content.get(field.getKey()).toString();
			field.setValue(value);
		}

		return new View("admin/content_create.jsp").data("fields", fields).data("contentId", id).data("menuId", menuId)
				.data("templetId", templetId);
	}

	@HasRoles("admin")
	@Request.Post("/content/update/{id}")
	public Result update(long id, Params params, Multiparts multiparts) {
		Map<String, Object> fieldMap = params.getFieldMap();
		Multipart multipart = multiparts.getOne();
		boolean success = contentService.update(id, fieldMap, multipart);

		long templetId = Long.parseLong((String) fieldMap.get("templetId"));
		long menuId = Long.parseLong((String) fieldMap.get("menuId"));
		Result result = new Result(success);
		Map<String, String> data = new HashMap<String, String>();
		data.put("menuId", menuId + "");
		data.put("templetId", templetId + "");
		result.setData(data);
		return result;

	}

}
