package org.demo.routerfunction.handler;

import org.apache.commons.lang3.StringUtils;
import org.demo.routerfunction.beans.Device;
import org.demo.routerfunction.service.DeviceService;
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
    private DeviceService deviceService;


    // 根据id查询设备
    public Mono<ServerResponse> findByIdHandler(ServerRequest request){
        String id = request.pathVariable("id");
        if(StringUtils.isEmpty(id)){
            return ServerResponse.notFound().build();
        }
        return ServerResponse.ok()  //响应码 200
                .contentType(MediaType.APPLICATION_JSON)
                .body(deviceService.getDeviceById(id), Device.class);
    }

    // 查询所有设备
    public Mono<ServerResponse> findAllHandler(ServerRequest request){
        return ServerResponse.ok()  //响应码 200
                .contentType(MediaType.APPLICATION_JSON)
                .body(deviceService.getAllDevices(), Device.class);
    }

    public Mono<ServerResponse> saveHandler(ServerRequest request){
        Mono<Device> deviceMono = request.bodyToMono(Device.class);
        return ServerResponse.ok().build(deviceService.save(deviceMono));
    }
}
