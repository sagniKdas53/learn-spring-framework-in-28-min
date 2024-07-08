package com.in28minutes.learnSpringFramework.examples.postNPreConst;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan("com.in28minutes.learnSpringFramework.examples.postNPreConst")
public class PostPreConstLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PostPreConstLauncher.class)) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));
            // Arrays.stream(context.getBeanDefinitionNames())
            //        .forEach(System.out::println);

            var dataBaseService = context.getBean(dataBaseService.class);
            System.out.println("In Main thread: " + dataBaseService);
        }
    }
}

@Component
class mapDataBase {
    private final Map<String, String> map;

    public mapDataBase() {
        this.map = new HashMap<>();
    }

    public mapDataBase(Map<String, String> map) {
        this.map = map;
    }

    @PostConstruct
    void init() {
        System.out.println("dataBase post construct called");
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("dataBase pre destroy called");
        map.clear();
    }

    public void clear() {
        //map.clear();
        System.out.println("Left to do to the preDestroy");
    }

    @Override
    public String toString() {
        return "dataBase{" +
                "map=" + map +
                '}';
    }
}

@Component
class listDataBase {
    private final List<List<Integer>> list;

    public listDataBase() {
        this.list = new ArrayList<>();
    }

    public listDataBase(List<List<Integer>> extList) {
        this.list = extList;
    }

    @PostConstruct
    public void init() {
        var lisT = new ArrayList<Integer>(2);
        lisT.add(0);
        lisT.add(1);
        list.add(lisT);
    }
}

@Component
class dataBaseService {
    private final mapDataBase mapDataBase;

    public dataBaseService(@Qualifier("mapDataBase") mapDataBase mapDataBase) {
        this.mapDataBase = mapDataBase;
    }

    @PostConstruct
    void init() {
        System.out.println("dataBaseService post construct called");
        //System.out.println(dataBase);
    }

    @Override
    public String toString() {
        return "dataBaseService{" +
                "dataBase=" + mapDataBase +
                '}';
    }

    @PreDestroy
    void destroy() {
        System.out.println("dataBaseService pre destroy called");
        mapDataBase.clear();
    }
}
