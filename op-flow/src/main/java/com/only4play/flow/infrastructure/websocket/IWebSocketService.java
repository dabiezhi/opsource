package com.only4play.flow.infrastructure.websocket;


import javax.websocket.Session;

import org.bson.Document;

public interface IWebSocketService {

    void onOpen(Session session, String id);

    void onClose(String id);

    void onError(Session session, Throwable error);

    void onMessage(String id, String message);

    void sendMessage(String id, Document message);
}