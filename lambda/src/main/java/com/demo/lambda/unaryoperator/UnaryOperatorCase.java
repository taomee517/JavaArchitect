package com.demo.lambda.unaryoperator;

import lombok.extern.slf4j.Slf4j;

import java.util.function.UnaryOperator;

@Slf4j
public class UnaryOperatorCase {
    public static void main(String[] args) {
        /* UnaryOperator 是一种特殊的Function，参数与返回值是同一类型 */
        UnaryOperator<Integer> squareOperator = n -> n * n;

        int data = 10;
        Integer apply = squareOperator.apply(data);
        log.info("{} 的平方是：{}", data, apply);

    }
}
