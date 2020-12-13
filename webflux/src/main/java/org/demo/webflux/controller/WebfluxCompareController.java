package org.demo.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping(value = "compare")
public class WebfluxCompareController {

    @GetMapping(value = "common")
    public String commonHandle(){
        String handler = "common handle";
        log.info("common handle start");
        String name = sleep(handler);
        log.info("common handle end");
        return name;
    }

    @GetMapping(value = "mono")
    public Mono<String> monoHandle(){
        String handler = "mono handle";
        log.info("mono handle start");
        Mono<String> mono = Mono.fromSupplier(() -> sleep(handler));
        log.info("mono handle end");
        return mono;
    }


    @GetMapping(value = "flux")
    public Flux<String> fluxHandle(){
        /* Mono: 表示包含0-1个元素的异步序列 */
        /* Flux: 表示包含0-n个元素的异步序列 */
        return Flux.just(getInterestsArray());
    }

    @GetMapping(value = "fluxArray")
    public Flux<String> fluxArray(){
        /* 将数组转化为flux */
        return Flux.fromArray(getInterestsArray());
    }

    @GetMapping(value = "fluxList")
    public Flux<String> fluxList(){
        /* 将集合转化为flux */
        return Flux.fromStream(getInterestsList().stream());
    }

    @GetMapping(value = "fluxWait")
    public Flux<String> fluxWait(){
        /* 模拟flux耗时操作 */
        log.info("fluxWait handle start");
        Flux<String> flux = Flux.fromStream(getInterestsList().stream().map(s -> sleep(StringUtils.join("Interest-", s))));
        log.info("fluxWait handle end");
        return flux;
    }

    @GetMapping(value = "sseWait", produces = "text/event-stream")
    public Flux<String> sseWait(){
        /* SSE-Server Sent Event 服务端推送事件 */
        log.info("sseWait handle start");
        Flux<String> flux = Flux.fromStream(getInterestsList().stream().map(s -> sleep(StringUtils.join("Interest-", s))));
        log.info("sseWait handle end");
        return flux;
    }




    private String sleep(String name){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }


    private List<String> getInterestsList(){
        return Arrays.asList("football", "basketball", "baseball");
    }

    private String[] getInterestsArray(){
        return new String[]{"football", "basketball", "baseball"};
    }
}
