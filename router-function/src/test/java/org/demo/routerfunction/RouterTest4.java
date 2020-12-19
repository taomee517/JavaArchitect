package org.demo.routerfunction;

import org.demo.routerfunction.beans.Device;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RouterTest4 {

    private WebClient client = WebClient.create("http://localhost:9327");

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
