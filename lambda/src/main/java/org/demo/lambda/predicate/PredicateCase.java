package org.demo.lambda.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class PredicateCase {
    public static void main(String[] args) {
        Predicate<Integer> lteZero = n -> n >= 0;
        int data1 = 0;
        int data2 = -49;
        int data3 = 28;
        boolean test1 = lteZero.test(data1);
        boolean test2 = lteZero.test(data2);
        boolean test3 = lteZero.test(data3);
        log.info("{} 判断结果为：{}", data1, test1);
        log.info("{} 判断结果为：{}", data2, test2);
        log.info("{} 判断结果为：{}", data3, test3);

        Predicate<Integer> isEven = n -> n%2 == 0;
        boolean evenTest1 = lteZero.and(isEven).test(data2);
        boolean evenTest2 = lteZero.and(isEven).test(data3);
        log.info("{} 大于等于0，且为偶数：{}", data2, evenTest1);
        log.info("{} 大于等于0，且为偶数：{}", data3, evenTest2);

        int data4 = -16;
        boolean orTest = isEven.or(lteZero).test(data4);
        log.info("{} 为偶数，或大于等于0：{}", data4, orTest);
    }
}
