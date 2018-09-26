package com.zzg.study.test.demo1;


import org.junit.Test;
import com.zzg.study.vo.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created user :zhangzhigang5
 * Created date :2018/9/25
 * Created desc :
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public class Jdk8Test1 {
    Logger log = Logger.getLogger("Jdk8Test1");

    @Test
    public void test(){
//        Supplier<Person> t=Person::new;
//
//        Person person=t.get();
//
//        person.setAlias("alias");
//        person.setName("name");
//
//        Consumer<Person> consumer=(p)->p.toString();
//        consumer.accept(person);
//
//        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//
//
//        Collections.sort(names,(String a,String b)->{
//            return 1;
//        });

//
//        Predicate<Integer> predicate=(s)->{
//            return s++==1;
//        };
//        log.info(predicate.test(2)+"---");



        //Collections.sort(list);
//        List<String> result=list.stream().filter((s)->!s.startsWith("a")).collect(Collectors.toList());

//        list.stream().filter((s) -> !s.startsWith("a")).sorted(new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        }).forEach(System.out::println);

//        log.info(result.toString());

        //list.sort();


//        boolean allTrue=list.stream().allMatch((s)->s.startsWith("a"));
//        log.info("match:"+allTrue);
//
//        boolean anyTrue=list.stream().anyMatch((s)->s.startsWith("a"));
//        log.info("match:"+anyTrue);
//
//        Set setList=list.stream().filter((s)->!s.startsWith("a")).collect(Collectors.toSet());
//        log.info("setList:"+setList);
//
//
//
//        Optional<String> reduced=list.stream().filter((s)->!s.startsWith("a")).reduce((s1,s2)->{
//            return s1+"###"+s2;
//        });
//
//        List<String> list=new ArrayList<String>();
//        list.add("a1");
//        list.add("z2");
//        list.add("c3");
//        list.add("b4");
//        list.add("g5");
//        list.add("d6");
//
//        list.parallelStream().sorted().forEachOrdered(System.out::println);
//        //log.info(list+""+count);
//
//        Map<String,String> testMap=new HashMap<>();
//
//        testMap.put("1","bb");

        //testMap.putIfAbsent("1","aa");

//        testMap.computeIfAbsent("1",(num,val)->{
//            return num+""+val;
//        });


//        log.info(""+testMap);


//        DefaultInterface.defaultStaticMethod();
//        new DefaultInterface(){}.defaultMethod();


        LambdaTest lt=(s1,s2)->s1+s2;


        LambdaTest lt2=lt::sum;


        int sum=lt2.sum(1,2);
        log.info(""+sum);

    }


}
