package org.demo.lambda.function;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

@Slf4j
public class FunctionCase {
    public static void main(String[] args) {
        /* Function 有输入，也有输出，第一个泛型是参数值类型， 第二个泛型是返回值类型 */
        Function<Integer, String> regret = year -> StringUtils.join("Hello！", year);
        String yearRegret = regret.apply(2021);
        System.out.println(yearRegret);

        Function<Integer, Integer> funDouble = n -> 2 * n;
        Function<Integer, Integer> funSquare = n -> n * n;
        int data = 13;
        Integer result1 = funSquare.apply(funDouble.apply(data));
        Integer result2 = funDouble.andThen(funSquare).apply(data);
        log.info("{}翻倍后再平方的结果是：{}", data, result1);
        log.info("{}翻倍后再平方的结果是：{}", data, result2);

        Integer result3 = funDouble.compose(funSquare).apply(data);
        log.info("{}平方后再翻倍的结果是：{}", data, result3);
    }
}
