package com.jomkie.service;

import com.jomkie.annotations.LogRecorder;
import com.jomkie.common.ResultObj;

/**
 * @author Jomkie
 * @since 2021-05-08 11:14:33
 * aop 拦截测试接口
 */
@LogRecorder
public interface AopService {

    ResultObj<String> testAopServerAndLog();

}
