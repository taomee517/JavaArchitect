package org.demo.lambda.binaryoperator;

import com.alibaba.fastjson.JSON;
import org.demo.lambda.evolution.entity.Man;
import org.demo.lambda.function.AgeComparator;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

@Slf4j
public class BinaryFunctionCase {
    public static void main(String[] args) {
        int a = 4;
        int b = 6;

        /* BinaryOperator 是一种特殊的BiFunction 两个参数，一个返回值，参数类型和返回值类型一样 */
        BiFunction<Integer, Integer, Integer> biFun = (x,y) -> x * y;
        Integer multiply = biFun.apply(a, b);
        log.info("multiply result: {}", multiply);

        BinaryOperator<Integer> bo = (x,y) -> x * y;
        Integer multiply1 = bo.apply(a, b);
        log.info("multiply result: {}", multiply1);

        BinaryOperator<Integer> max = Math::max;
        Integer maxApply = max.apply(a, b);
        log.info("max result: {}", maxApply);


        Man lee = new Man("lee", 30);
        Man wang = new Man("wang", 28);
        BinaryOperator<Man> maxBy = BinaryOperator.maxBy(new AgeComparator());
        Man oldMan = maxBy.apply(lee, wang);
        log.info("老男人是：{}", JSON.toJSONString(oldMan));
    }
}
