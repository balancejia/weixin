package balance.weixin.cms.service.impl;

import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.framework.tx.annotation.Transaction;
import org.smart4j.framework.util.DateUtil;

import balance.weixin.cms.entity.Log;
import balance.weixin.cms.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    @Override
    @Transaction
    public void log(String description) {
        Log log = new Log();
        log.setDate(DateUtil.getCurrentDate());
        log.setTime(DateUtil.getCurrentTime());
        log.setDescription(description);
        DataSet.insert(log);

//        // 故意让事务回滚
//        throw new RuntimeException();
    }
}
