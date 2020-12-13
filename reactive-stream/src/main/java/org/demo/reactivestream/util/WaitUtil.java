package org.demo.reactivestream.util;

import java.util.concurrent.TimeUnit;

public class WaitUtil {
    public static void sleep(int millis){
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
