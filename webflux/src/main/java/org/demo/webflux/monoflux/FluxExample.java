package org.demo.webflux.monoflux;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FluxExample {
    public static void main(String[] args) {
        // just 方法直接声明
        Flux.just(1, 2, 3, 4).subscribe(System.err::println);

        // 其它from方法
        Integer[] array = {1, 2, 3, 4};
        Flux.fromArray(array);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        Flux.fromIterable(integers);

        IntStream intStream = IntStream.range(1, 5);
        Flux.fromStream(intStream.boxed());
    }
}
