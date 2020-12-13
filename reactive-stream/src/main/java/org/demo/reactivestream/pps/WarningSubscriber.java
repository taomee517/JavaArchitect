package org.demo.reactivestream.pps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WarningSubscriber implements Flow.Subscriber<String> {
    //声明订阅关系
    private Flow.Subscription subscription;
    private CountDownLatch latch;

    public WarningSubscriber(CountDownLatch latch) {
        this.latch = latch;
    }

    //当订阅关系确立时，即publisher.subscribe() -> 会触发onSubscribe接口方法
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        log.info("与告警processor建立订阅关系");
        this.subscription = subscription;
        subscription.request(1);
    }

    //对消息的消费过程就在onNext接口方法执行
    //该方法的第一次执行是由onSubscribe方法中的subscription.request(5)触发
    @Override
    public void onNext(String item) {
        log.info("收到水位告警消息 == >>> {}", item);
        //订阅者第消费一条消息就会再订阅一些消息
        subscription.request(1);
        sleep(10);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        //取消订阅关系
        subscription.cancel();
    }

    //所有消息消费完成后触发
    @Override
    public void onComplete() {
        log.info("所有水位报警消息消费完成");
        latch.countDown();
    }


    private void sleep(int millis){
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
