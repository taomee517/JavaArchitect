package org.demo.routerfunction.controller;

import org.demo.routerfunction.beans.Device;
import org.demo.routerfunction.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("commonDevice")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping(value = "all")
    public Flux<Device> findAll(){
        return deviceService.getAllDevices();
    }

    @GetMapping(value = "/{id}")
    public Mono<Device> findOne(@PathVariable(value = "id") String id){
        return deviceService.getDeviceById(id);
    }

    @PostMapping(value = "save")
    public Mono<String> save(@RequestBody Device device){
        return deviceService.save(Mono.just(device)).then(Mono.just("Save Success!"));
    }

    @DeleteMapping(value = "/{id}")
    public Mono<String> delete(@PathVariable(value = "id") String id){
        return deviceService.deleteDeviceById(id).then(Mono.just("Delete Success!"));
    }

    @PostMapping(value = "update")
    public Mono<String> update(@RequestBody Device device){
        return deviceService.edit(Mono.just(device)).then(Mono.just("Update Success!"));
    }
}
