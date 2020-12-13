package org.demo.reactivestream.pps;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PpsStarter {
    public static void main(String[] args) {
        /**
         * publisher - processor - subscriber 模型
         */
        CountDownLatch latch = new CountDownLatch(1);
        SubmissionPublisher<Integer> levelPublisher = null;
        WarningJudgeProcessor warningProcessor = null;
        try {
            levelPublisher = new SubmissionPublisher<>();
            warningProcessor = new WarningJudgeProcessor();
            WarningSubscriber warningSubscriber = new WarningSubscriber(latch);

            levelPublisher.subscribe(warningProcessor);
            warningProcessor.subscribe(warningSubscriber);

            for (int i = 0; i < 300; i++) {
                int waterLevel = new Random().nextInt(60) + 100;
                log.info("上报第{}条水位数据: level = {}", i, waterLevel);
                levelPublisher.submit(waterLevel);
            }
            latch.await(20, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(warningProcessor!=null) warningProcessor.close();
            if(levelPublisher!=null) levelPublisher.close();
        }
    }
}
