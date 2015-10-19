package balance.weixin.cms.action;

import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.mvc.bean.View;
import org.smart4j.framework.util.StringUtil;
import org.smart4j.framework.util.WebUtil;
import org.smart4j.plugin.security.SecurityHelper;
import org.smart4j.plugin.security.annotation.HasRoles;
import org.smart4j.plugin.security.fault.LoginException;

import balance.weixin.Constant;

@Action
public class SystemAction {

    @Request.Get("/captcha")
    public void captcha() {
        String captcha = WebUtil.createCaptcha(DataContext.getResponse());
        DataContext.Session.put(Constant.CAPTCHA, captcha);
    }

    @Request.Get("/login")
    public View login() {
        return new View("admin/login.jsp");
    }

    @HasRoles("admin")
    @Request.Get("/admin")
    public View admin() {
        return new View("admin/admin_index.jsp");
    }

    @Request.Get("/admin/index")
    public View adminIndex() {
        return new View("admin/index.jsp");
    }

    @Request.Post("/login")
    public Result login(Params params) {
        String username = params.getString("username");
        String password = params.getString("password");
        String captcha = params.getString("captcha");

        String sessionCaptcha = DataContext.Session.get(Constant.CAPTCHA);
        if (StringUtil.isNotEmpty(sessionCaptcha) && !sessionCaptcha.equals(captcha)) {
            return new Result(false).data("captcha_error");
        }

        try {
            SecurityHelper.login(username, password, false);
        } catch (LoginException e) {
            return new Result(false);
        }

        return new Result(true);
    }

    @Request.Get("/logout")
    public Result logout() {
        SecurityHelper.logout();
        return new Result(true);
    }
}
