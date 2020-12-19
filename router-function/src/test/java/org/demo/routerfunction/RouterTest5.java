package org.demo.routerfunction;

import org.demo.routerfunction.beans.Device;
import org.demo.routerfunction.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import reactor.core.publisher.Flux;


@SpringBootTest
@SpringJUnitWebConfig
public class RouterTest5 {

    @Autowired
    DeviceRepository deviceRepository;

    @Test
    public void deviceTest(){
        Flux<Device> all = deviceRepository.findAll();
        all.log().doOnNext(device -> System.out.println(device)).subscribe();
    }
}
