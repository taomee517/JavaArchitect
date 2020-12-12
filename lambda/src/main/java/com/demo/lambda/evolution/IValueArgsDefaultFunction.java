package com.demo.lambda.evolution;

@FunctionalInterface
public interface IValueArgsDefaultFunction {
    String execute(String s, int n);
    default String desc(String s, int n){
        return "接口默认方法，方法参数：" + s + ", " + n;
    }
}
