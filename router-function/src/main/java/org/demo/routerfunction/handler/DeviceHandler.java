package org.demo.routerfunction.handler;

import org.apache.commons.lang3.StringUtils;
import org.demo.routerfunction.beans.Device;
import org.demo.routerfunction.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

//处理器类

@Component
public class DeviceHandler {

    @Autowired
    private DeviceRepository repository;


    // 根据id查询设备
    public Mono<ServerResponse> findByIdHandler(ServerRequest request){
        String id = request.pathVariable("id");
        if(StringUtils.isEmpty(id)){
            return ServerResponse.notFound().build();
        }
        Mono<Device> deviceMono = repository.findById(id);
        return ServerResponse.ok()  //响应码 200
                .contentType(MediaType.APPLICATION_JSON)
                .body(deviceMono, Device.class);
    }

    // 查询所有设备
    public Mono<ServerResponse> findAllHandler(ServerRequest request){
        return ServerResponse.ok()  //响应码 200
                .contentType(MediaType.APPLICATION_JSON)
                .body(repository.findAll(), Device.class);
    }

    public Mono<ServerResponse> saveHandler(ServerRequest request){
        Mono<Device> deviceMono = request.bodyToMono(Device.class);
        Mono<Void> save = deviceMono.doOnNext(device -> repository.save(device)).then();
        return ServerResponse.ok().build(save);
    }
}
