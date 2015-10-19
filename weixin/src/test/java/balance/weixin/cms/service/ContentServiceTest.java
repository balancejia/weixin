package balance.weixin.cms.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.smart4j.framework.ioc.BeanHelper;

import balance.weixin.cms.service.impl.ContentServiceImpl;

public class ContentServiceTest {

	private ContentService service = BeanHelper
			.getBean(ContentServiceImpl.class);

	//@Test
	public void testGetContentList() {
		List<Map<String, Object>> list = service.getContentList(1L);

		System.out.println(list.size());

		Assert.assertEquals(list.size(), 4);
	}

	// @Test
	public void testCreate() {

		Map<String, Object> content1 = new LinkedHashMap<String, Object>();

		content1.put("image", "1.jpg");
		content1.put("name", "可乐12罐");
		content1.put("price", 30);
		content1.put("summary", "国庆大促销");
		content1.put("detail", "xiejiejiejie");
		content1.put("discount", 25);
		content1.put("templetId", 1L);
		content1.put("menuId", 1L);

		Map<String, Object> content2 = new LinkedHashMap<String, Object>();

		content2.put("image", "2.jpg");
		content2.put("name", "康师傅一箱");
		content2.put("price", 10);
		content2.put("summary", "国庆大促销");
		content2.put("detail", "康师傅");
		content2.put("discount", 3);
		content2.put("templetId", 1L);
		content2.put("menuId", 1L);

		service.create(content1, null);
		service.create(content2, null);

	}

	@Test
	public void insertNews() {
		Map<String, Object> content1 = new LinkedHashMap<String, Object>();



		content1.put("name", "品牌14");
		content1.put("image", "b5.jpg");
		content1.put("submmary", "");
		content1.put("ditail","");
		content1.put("address", "万达广场");
		content1.put("phone", "0359-4256565");
		content1.put("activity", "冬季打折活动");
		content1.put("templetId", 2L);
		content1.put("menuId", 4L);

		service.create(content1, null);
	}

}
