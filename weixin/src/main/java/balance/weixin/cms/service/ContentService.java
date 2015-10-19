package balance.weixin.cms.service;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.mvc.bean.Multipart;

public interface ContentService {

	List<Map<String, Object>> getContentList(long menuId);

	boolean create(Map<String, Object> fieldMap, Multipart multipart);

	List<Map<String, Object>> getActContents();

	Map<String, Object> getContent(long id);

	Pager<Map<String,Object>> getContentPager(int pageNumber, int pageSize, long menuId);

	boolean delete(long id);

	boolean update(long id, Map<String, Object> fieldMap, Multipart multipart);

}
