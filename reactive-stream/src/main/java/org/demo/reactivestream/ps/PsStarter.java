package org.demo.reactivestream.ps;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.SubmissionPublisher;

@Slf4j
public class PsStarter {

    public static void main(String[] args) {
        /**
         * publisher - subscriber 模型
         */
        SubmissionPublisher<Integer> levelPublisher = null;
        try {
            levelPublisher = new SubmissionPublisher<>();
            LevelSubscriber levelSubscriber = new LevelSubscriber();
            levelPublisher.subscribe(levelSubscriber);

            for (int i = 0; i < 300; i++) {
                int waterLevel = new Random().nextInt(60) + 100;
                log.info("上报第{}条水位数据: level = {}", i, waterLevel);
                levelPublisher.submit(waterLevel);
            }
            Thread.currentThread().join(35000);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(levelPublisher!=null) levelPublisher.close();
        }
    }
}
