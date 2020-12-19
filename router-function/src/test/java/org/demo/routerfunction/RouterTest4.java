package org.demo.routerfunction;

import org.demo.routerfunction.beans.Device;
import org.demo.routerfunction.repository.DeviceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RouterTest4 {

    @Autowired
    DeviceRepository deviceRepository;

    @Test
    public void deviceTest(){
        Flux<Device> all = deviceRepository.findAll();
        all.log().doOnNext(device -> System.out.println(device)).subscribe();
    }
}
