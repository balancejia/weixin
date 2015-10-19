package balance.weixin.cms.service.impl;

import java.util.List;

import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;

import balance.weixin.cms.entity.Role;
import balance.weixin.cms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> getRoleList() {
        return DataSet.selectList(Role.class);
    }
}
