package org.demo.routerfunction.service;

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

    public Mono<Device> getDeviceById(String id){
        return repository.findById(id);
    }

    public Flux<Device> getAllDevices(){
        return repository.findAll();
    }

    public Mono<Void> save(Mono<Device> deviceMono){
        return deviceMono.doOnNext(device -> repository.save(device).subscribe())
                .thenEmpty(Mono.empty());
    }

    public Mono<Void> deleteDeviceById(String id) {
        return repository.deleteById(id);
    }

    public Mono<Void> edit(Mono<Device> upd) {
        return upd.flatMap(updDevice -> repository.save(updDevice).then());
    }
}
