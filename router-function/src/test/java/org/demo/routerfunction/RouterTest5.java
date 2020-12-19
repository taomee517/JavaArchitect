package org.demo.routerfunction;

import org.demo.routerfunction.beans.Device;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@SpringBootTest
@SpringJUnitWebConfig
public class RouterTest5 {

    private  WebClient client = WebClient.create("http://localhost:9327");

    @Test
    public void deviceTest(){
        Flux<Device> all = client.get().uri("/device/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(Device.class);
        all.map(device -> device.getMAC())
                .doOnNext(System.err::println)
                .blockLast();
    }
}
