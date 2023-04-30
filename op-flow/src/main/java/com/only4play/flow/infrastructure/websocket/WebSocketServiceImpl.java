package com.only4play.flow.infrastructure.websocket;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebSocketServiceImpl implements IWebSocketService {

    /** 每个流程id对应一个session */
    private static final Map<String, Session> SESSION_POOL = new ConcurrentHashMap<>();

    @Override
    public void onOpen(Session session, String id) {
        SESSION_POOL.put(id, session);
        sendMessage(id,new Document().append("111","12212"));
    }

    @SneakyThrows
    @Override
    public void onClose(String id) {
        Session session = SESSION_POOL.remove(id);
        session.close();
        log.info("Client disconnected, id:{}", id);
    }

    @Override
    public void onError(Session session, Throwable error) {
        log.error("websocket session {} onError:{}", session.getId(), error.getMessage());
    }

    @Override
    public void onMessage(String id, String message) {
        log.info("Received client message:{}", message);
    }

    @Override
    public void sendMessage(String id, Document message) {
        if (SESSION_POOL.get(id) != null) {
            try {
                synchronized (SESSION_POOL.get(id)) {
                    SESSION_POOL.get(id).getBasicRemote().sendText(message.toJson());
                }
            } catch (Exception e) {
                log.error("Send websocket message failed:{}", e.getMessage());
            }
        }
    }
}