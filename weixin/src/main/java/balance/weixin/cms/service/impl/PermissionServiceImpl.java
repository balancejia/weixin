package balance.weixin.cms.service.impl;

import java.util.List;

import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;

import balance.weixin.cms.entity.Permission;
import balance.weixin.cms.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<Permission> getPermissionList() {
        return DataSet.selectList(Permission.class);
    }
}
