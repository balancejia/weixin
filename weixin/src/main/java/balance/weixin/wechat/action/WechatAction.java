/**
 *
 */
package balance.weixin.wechat.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;

import balance.weixin.wechat.service.LotteryWechat;

/**
 * @author balancejia
 *
 */
@Action
public class WechatAction {

	private static final Logger logger = LoggerFactory.getLogger(WechatAction.class);

	@Request.Get("/wechat")
	public void get() {
		executePost();
	}

	@Request.Post("/wechat")
	public void post() {
		executePost();
	}

	private void executePost() {
		LotteryWechat wechat = new LotteryWechat(DataContext.getRequest());
		String result = wechat.execute();
		write(DataContext.getResponse(), result);
	}

	private void write(HttpServletResponse resp, String result) {
		try {
			ServletOutputStream out = resp.getOutputStream();
			out.write(result.getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.error("在响应中写数据出错！", e);
			throw new RuntimeException(e);
		}
	}

}
