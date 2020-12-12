package com.demo.lambda.function;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class FunctionCase {
    public static void main(String[] args) {
        /* Consumer 有输入，也有输出，第一个泛型是参数值类型， 第二个泛型是返回值类型 */
        Function<Integer, String> regret = year -> StringUtils.join("Hello！", year);
        String yearRegret = regret.apply(2021);
        System.out.println(yearRegret);

        Function<Integer, Integer> funDouble = n -> 2 * n;
        Function<Integer, Integer> funSquare = n -> n * n;
        int data = 13;
        Integer result = funSquare.apply(funDouble.apply(data));
        String join = StringUtils.join(data, "翻倍后再平方的结果是：", result);
        System.out.println(join);
    }
}
