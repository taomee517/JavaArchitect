package org.demo.routerfunction.handler;

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

    public Mono<ServerResponse> findAllHandler(ServerRequest request){
        return ServerResponse.ok()  //响应码 200
                .contentType(MediaType.APPLICATION_JSON)
                .body(repository.findAll(), Device.class);
    }
}
