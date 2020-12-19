package org.demo.routerfunction.service;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.demo.routerfunction.beans.Device;
import org.demo.routerfunction.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository repository;

    public Mono<Device> getDeviceById(@Parameter(in = ParameterIn.PATH) String id){
        return repository.findById(id);
    }

    public Flux<Device> getAllDevices(){
        return repository.findAll();
    }

    public Mono<Void> save(@Parameter(in = ParameterIn.PATH) Mono<Device> deviceMono){
        return deviceMono.doOnNext(device -> repository.save(device).subscribe())
                .thenEmpty(Mono.empty());
    }
}
