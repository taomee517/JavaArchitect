package org.demo.lambda.evolution;

import jdk.jfr.Description;
import org.junit.Test;

public class VoidFuncTest {

    @Test
    @Description(value = "匿名内部类方式")
    public void test1(){
        IVoidFunction voidFunction = new IVoidFunction() {
            @Override
            public void execute() {
                System.out.println("anonymous executing");
            }
        };
        voidFunction.execute();
    }

    @Test
    @Description(value = "Lambda方式")
    public void test2(){
        IVoidFunction voidFunction = () -> {
            System.out.println("lambda executing");
        };
        voidFunction.execute();
    }
}
