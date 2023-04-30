package com.only4play.flow.infrastructure.websocket;


import javax.websocket.server.ServerEndpointConfig;

public class WebSocketConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        // 通过 Spring 应用上下文获取实例
        return ApplicationContextProvider.getApplicationContext().getBean(endpointClass);
    }
}