package com.jomkie.service.log;

import com.jomkie.common.ResultObj;
import com.jomkie.service.AopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Jomkie
 * @since 2021-05-08 11:15:38
 * 日志层
 */
@Service("aopServiceLog")
@Slf4j
public class AopServiceLog implements AopService {

    @Override
    public ResultObj<String> testAopServerAndLog() {
        log.info("entered -----------------------> AopServiceLog.testAopServerAndLog()");
        return ResultObj.success("AopServiceLog.testAopServerAndLog");
    }

}
