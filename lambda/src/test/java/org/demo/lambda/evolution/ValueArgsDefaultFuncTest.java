package org.demo.lambda.evolution;

import jdk.jfr.Description;
import org.junit.Test;

public class ValueArgsDefaultFuncTest {

    @Test
    @Description(value = "匿名内部类方式")
    public void test1(){
        IValueArgsDefaultFunction valueArgsDefaultFunction = new IValueArgsDefaultFunction() {
            @Override
            public String execute(String s, int n) {
                return "anonymous result:" + s + n;
            }
        };
        String executeResult = valueArgsDefaultFunction.execute("Hello! ", 2020);
        System.out.println(executeResult);

        String desc = valueArgsDefaultFunction.desc("Hello! ", 2020);
        System.out.println(desc);
    }

    @Test
    @Description(value = "Lambda方式1")
    public void test2(){
        IValueArgsDefaultFunction valueArgsDefaultFunction = (s, n) -> {
            return "lambda result:" + s + n;
        };
        String executeResult = valueArgsDefaultFunction.execute("Hello! ", 2020);
        System.out.println(executeResult);

        String desc = valueArgsDefaultFunction.desc("Hello! ", 2020);
        System.out.println(desc);
    }

    @Test
    @Description(value = "Lambda方式2,更为简洁")
    public void test3(){
        IValueArgsDefaultFunction valueArgsDefaultFunction = (s, n) -> "lambda result:" + s + n;
        String executeResult = valueArgsDefaultFunction.execute("Hello! ", 2021);
        System.out.println(executeResult);

        String desc = valueArgsDefaultFunction.desc("Hello! ", 2021);
        System.out.println(desc);
    }
}
