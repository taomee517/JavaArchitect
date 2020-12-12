package com.demo.lambda.bifunction;

import com.alibaba.fastjson.JSON;
import com.demo.lambda.evolution.entity.Man;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.function.BiFunction;

@Slf4j
public class BiFunctionCase {
    public static void main(String[] args) {
        /* BiFunction 两个参数，一个返回值，前两个泛型是参数类型，最后一个泛型是返回值类型 */
        BiFunction<Integer, Man, String> biFun = (n,man) -> StringUtils.join("{", n, ":", JSON.toJSONString(man), "}");
        Man man = new Man();
        man.setName("王枫");
        man.setAge(29);
        String apply = biFun.apply(1, man);
        log.info("Key-Value: {}", apply);
    }
}
