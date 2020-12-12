package org.demo.lambda.evolution;

import jdk.jfr.Description;
import org.junit.Test;

public class VoidArgsFuncTest {

    @Test
    @Description(value = "匿名内部类方式")
    public void test1(){
        IVoidArgsFunction voidArgsFunction = new IVoidArgsFunction() {
            @Override
            public void execute(String s, int n) {
                System.out.println("anonymous regret:" + s + n);
            }
        };
        voidArgsFunction.execute("Hello! ", 2020);
    }

    @Test
    @Description(value = "Lambda方式")
    public void test2(){
        IVoidArgsFunction voidArgsFunction = (s, n) -> {
            System.out.println("lambda regret:" + s + n);
        };
        voidArgsFunction.execute("Hello! ", 2020);
    }
}
