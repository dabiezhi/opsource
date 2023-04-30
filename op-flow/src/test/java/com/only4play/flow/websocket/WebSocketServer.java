package com.only4play.flow.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint("/websocket")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Received message: " + message);
        try {
            session.getBasicRemote().sendText("Server received message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("WebSocket closed: " + closeReason.getReasonPhrase());
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error: " + throwable.getMessage());
    }
}
