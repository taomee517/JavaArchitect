package com.demo.lambda.supplier;

import java.util.function.Supplier;

public class SupplierCase {
    public static void main(String[] args) {
        /* Supplier没有输入，但有输出，泛型是返回值类型 */
        Supplier<String> lambdaSupplier = () -> "lambda";
        String lambda = lambdaSupplier.get();
        System.out.println(lambda);
    }
}
