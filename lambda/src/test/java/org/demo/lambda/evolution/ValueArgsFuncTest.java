package org.demo.lambda.evolution;

import jdk.jfr.Description;
import org.junit.Test;

public class ValueArgsFuncTest {

    @Test
    @Description(value = "匿名内部类方式")
    public void test1(){
        IValueArgsFunction valueArgsFunction = new IValueArgsFunction() {
            @Override
            public String execute(String s, int n) {
                return "anonymous result:" + s + n;
            }
        };
        String executeResult = valueArgsFunction.execute("Hello! ", 2020);
        System.out.println(executeResult);
    }

    @Test
    @Description(value = "Lambda方式1")
    public void test2(){
        IValueArgsFunction valueArgsFunction = (s, n) -> {
            return "lambda result:" + s + n;
        };
        String executeResult = valueArgsFunction.execute("Hello! ", 2020);
        System.out.println(executeResult);
    }

    @Test
    @Description(value = "Lambda方式2,更为简洁")
    public void test3(){
        IValueArgsFunction valueArgsFunction = (s, n) -> "lambda result:" + s + n;
        String executeResult = valueArgsFunction.execute("Hello! ", 2021);
        System.out.println(executeResult);
    }
}
