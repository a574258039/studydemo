package com.zzg.study.vo;

import java.util.logging.Logger;

/**
 * Created user :zhangzhigang5
 * Created date :2018/9/25
 * Created desc :算法
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public interface DefaultInterface {

    Logger log = Logger.getLogger("DefaultInterface");

    default void defaultMethod() {
        log.info("DefaultInterface#DefaultInterface");
    }

    static void defaultStaticMethod() {
        log.info("DefaultInterface#defaultStaticMethod");
    }

}
