package org.demo.routerfunction.controller;

import io.swagger.annotations.Api;
import org.demo.routerfunction.beans.Device;
import org.demo.routerfunction.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Api
@RestController
@RequestMapping("commonDevice")
public class DeviceController {

    @Autowired
    private DeviceRepository repository;

    @GetMapping(value = "all")
    public Flux<Device> findAll(){
        return repository.findAll();
    }
}
