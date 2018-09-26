package com.zzg.study.vo;

import java.util.logging.Logger;

/**
 * Created user :zhangzhigang5
 * Created date :2018/9/25
 * Created desc :
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public class Person {

    Logger log = Logger.getLogger("Person");

    private String name;
    private String alias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Person() {
    }

    public Person(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    @Override
    public String toString() {
        log.info("do person toString!");
        return "Person{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
