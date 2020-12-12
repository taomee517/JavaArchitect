package org.demo.lambda.evolution.entity;

import org.apache.commons.lang3.StringUtils;

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void sleep(int hours){
        System.out.println("睡眠" + hours + "小时");
    }

    public void eat(String food){
        String eating = StringUtils.join(name, "正在吃", food);
        System.out.println(eating);
    }

    public String play(String game){
        return StringUtils.join(name, "喜欢玩",game);
    }

    public String study(int hours){
        return StringUtils.join(name, "学习了", hours, "个小时");
    }
}
