package balance.weixin.cms.service;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.mvc.bean.Multipart;

import balance.weixin.cms.bean.ProductBean;
import balance.weixin.cms.entity.Product;
import balance.weixin.cms.entity.ProductType;

public interface ProductService {

    boolean createProduct(Map<String, Object> fieldMap, Multipart multipart);

    boolean deleteProduct(long id);

    boolean updateProduct(long id, Map<String, Object> fieldMap, Multipart multipart);

    Product getProduct(long id);

    ProductBean getProductBean(long id);

    Pager<ProductBean> getProductBeanPager(int pageNumber, int pageSize, String name);

    List<ProductType> getProductTypeList();
}
