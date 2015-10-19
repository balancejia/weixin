package balance.weixin.cms.service;

import java.util.List;
import java.util.Map;

import balance.weixin.cms.bean.UserBean;
import balance.weixin.cms.entity.User;

public interface UserService {

    void login(String username, String password);

    @Deprecated
    List<User> findUserList();

    List<UserBean> findUserBeanList();

    @Deprecated
    List<User> findUserListByUsername(String username);

    List<UserBean> findUserBeanListByUsername(String username);

    @Deprecated
    User findUser(long userId);

    UserBean findUserBean(long userId);

    boolean saveUser(Map<String, Object> fieldMap);

    boolean updateUser(long userId, Map<String, Object> fieldMap);

    boolean deleteUser(long userId);
}
