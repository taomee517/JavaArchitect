package org.demo.lambda.consumer;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;

public class ConsumerCase {
    public static void main(String[] args) {
        /* Consumer 有输入，但没有输出，泛型是参数值类型 */
        Consumer<String> consumer = str -> System.out.println(StringUtils.join("Hello!", str));
        consumer.accept("Webflux");

        Consumer<Integer> intCon1 = n -> System.out.println("翻倍后：" + 2 * n);
        Consumer<Integer> intCon2 = n -> System.out.println("平方后：" + n * n);
        intCon1.andThen(intCon2).accept(8);
    }
}
