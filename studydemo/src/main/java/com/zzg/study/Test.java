package com.zzg.study;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class Test {
    public static void main(String[] args) {
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime localDateTime2 = localDateTime.plusDays(500);
//
//        Duration duration = Duration.between(localDateTime, localDateTime2);
//
//
//        System.out.printf("" + duration.toDays());

        Map<String,List<String>> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        list.add("1");
        map.put("a",list);

      List list2=map.computeIfAbsent("a",k->new ArrayList());

       // list.add("1"+list2);

        System.out.printf(""+map);

//       String aaa=String.format("SSS_%s_AAA_%s","111");
//
//
//        System.out.printf(""+aaa);


    }
}
