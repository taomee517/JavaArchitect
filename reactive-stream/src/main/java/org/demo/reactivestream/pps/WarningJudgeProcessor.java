package org.demo.reactivestream.pps;

import lombok.extern.slf4j.Slf4j;
import org.demo.reactivestream.util.WaitUtil;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

@Slf4j
public class WarningJudgeProcessor extends SubmissionPublisher<String> implements Flow.Processor<Integer, String> {
    //声明订阅关系
    private static Flow.Subscription subscription;
    public static final int WARNING_LEVEL = 150;

    //当订阅关系确立时，即publisher.subscribe() -> 会触发onSubscribe接口方法
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(5);
    }

    //对消息的消费过程就在onNext接口方法执行
    //该方法的第一次执行是由onSubscribe方法中的subscription.request(5)触发
    @Override
    public void onNext(Integer item) {
        log.info("收到传感器上报数据, 当前水位：{} 米", item);

        //订阅者第消费一条消息就会再订阅一些消息
        subscription.request(5);

        if(item > WARNING_LEVEL){
            String warningMsg = "当前长江水位：" + item + "米，超过警戒水位" + WARNING_LEVEL + "米";
            this.submit(warningMsg);
        }

        WaitUtil.sleep(50);
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
        log.info("所有传感器水位数据消费完成");
    }
}
