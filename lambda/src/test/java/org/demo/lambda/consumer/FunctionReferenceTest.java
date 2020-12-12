package org.demo.lambda.consumer;

import org.demo.lambda.evolution.entity.Person;
import jdk.jfr.Description;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionReferenceTest {

    @Test
    @Description(value = "常规静态方法引用")
    public void test1(){
        Person person = new Person();
        person.setName("何佳俊");
        Person.sleep(8);

        String playGame = person.play("篮球");
        System.out.println(playGame);
    }

    @Test
    @Description(value = "lambda-Consumer方式静态方法引用")
    public void test2(){
        /* 静态方法引用 */
        //sleep()方法只有一个输入，没有输出，符合函数式接口Consumer的定义
        Consumer<Integer> consumer = Person::sleep;
        //consumer.accept(n)相当于Person.sleep(8)
        consumer.accept(8);
    }

    @Test
    @Description(value = "lambda-Function方式实例方法引用")
    public void test3(){
        Person person = new Person();
        person.setName("何佳俊");

        /* 实例方法引用 */
        //play()方法只有一个输入，且有输出，符合函数式接口Function的定义
        Function<String, String> playFun = person::play;
        String playGame = playFun.apply("足球");
        System.out.println(playGame);
    }

    @Test
    @Description(value = "lambda-BiFunction方式实例方法引用")
    public void test4(){
        Person person = new Person();
        person.setName("何佳俊");

        /* 实例方法引用 */

        BiFunction<Person, String, String> biFunPlay = Person::play;
        String playGame = biFunPlay.apply(person, "足球");
        System.out.println(playGame);

        BiFunction<Person, Integer, String> biFunStudy = Person::study;
        String study = biFunStudy.apply(person, 2);
        System.out.println(study);
    }


    @Test
    @Description(value = "lambda-Consumer方式实例方法引用")
    public void test5(){
        Person person = new Person();
        person.setName("何佳俊");

        Consumer<String> consumer = person::eat;
        consumer.accept("面包");
    }


    @Test
    @Description(value = "lambda-Supplier方式无参构造方法引用")
    public void test6(){
        // 无输入但有输出， 符合函数式接口Supplier的定义
        Supplier<Person> newPerson = Person::new;
        Person person = newPerson.get();
        System.out.println(person.getName());
    }

    @Test
    @Description(value = "lambda-Function方式有参构造方法引用")
    public void test7(){
        // 无输入但有输出， 符合函数式接口Supplier的定义
        Function<String, Person> personConstructor = Person::new;
        Person lee = personConstructor.apply("李林");
        System.out.println(lee.study(3));
    }
}
