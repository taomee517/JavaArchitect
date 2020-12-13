package org.demo.sse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Controller
@RequestMapping("sse")
public class SseController {

    @RequestMapping(value = "common")
    public void common(HttpServletResponse response) throws Exception{
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter writer = response.getWriter();
        for(int i=0; i<10; i++){
            writer.println(i);
            writer.flush();
            sleep(1);
        }
    }


    @RequestMapping(value = "std")
    public void sseStd(HttpServletResponse response) throws Exception{
        /* SSE标准规则： content-type为"text/event-stream"
        *  字符集仅支持：UTF-8 */
        response.setContentType(MediaType.TEXT_EVENT_STREAM_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("x-content-type-options", "nosniff");

        PrintWriter writer = response.getWriter();
        for(int i=0; i<10; i++){
            writer.println("data:" + i);
            writer.println("id:" + i);
            writer.flush();
            sleep(1);
        }
    }

    /* 需要以WebApplicationType.REACTIVE方式启动 */
    @ResponseBody
    @RequestMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> sseFlux() throws Exception{
        log.info("sseFlux handle start");
        List<Integer> collect = Stream.iterate(0, i -> i + 1)
                .limit(11).collect(Collectors.toList());
        Flux<String> stringFlux = Flux.fromStream(collect.stream()
                .map(i -> sleepAndReturn(1, i)));
        log.info("sseFlux handle end");
        return stringFlux;
    }


    public void sleep(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String sleepAndReturn(int time, int value){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (value == 10) {
            return "event:close";
        }
        return Integer.toString(value);
    }
}
