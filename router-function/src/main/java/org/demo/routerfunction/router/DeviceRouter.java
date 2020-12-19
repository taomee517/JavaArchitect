package org.demo.routerfunction.router;

import org.demo.routerfunction.handler.DeviceHandler;
import org.demo.routerfunction.service.DeviceService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

@Component
public class DeviceRouter {

    //用于将请求路由到指定的处理器类
    @Bean
    RouterFunction<ServerResponse> customRouter(DeviceHandler deviceHandler){
        return RouterFunctions
                //相当于普通springboot的@RequestMapping("/device")
                .nest(RequestPredicates.path("/device"),
                //相当于普通springboot的@GetMapping("/all")
                RouterFunctions.route(RequestPredicates.GET("/all"), deviceHandler::findAllHandler)
                    .andRoute(RequestPredicates.GET("/{id}"), deviceHandler::findByIdHandler)
                    .andRoute(RequestPredicates.POST("/save"), deviceHandler::saveHandler));
    }
}
