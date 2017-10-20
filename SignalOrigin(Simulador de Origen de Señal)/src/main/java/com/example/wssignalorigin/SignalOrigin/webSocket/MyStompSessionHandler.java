/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wssignalorigin.SignalOrigin.webSocket;


import com.example.wssignalorigin.SignalOrigin.signal.values.ECGSignalValue;
import org.apache.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

/**
 *
 * @author Andrés Felipe
 */
public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = Logger.getLogger(MyStompSessionHandler.class);
    
    
    
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/topic/ECGsignaltoclient", this);
        logger.info("Subscribed to /topic/ECGsignaltoserver");
        session.send("/app/beginECG/123", getSampleMessage());
        logger.info("Message sent to websocket server");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
        System.out.println(exception.getStackTrace());
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return ECGSignalValue.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        ECGSignalValue msg = (ECGSignalValue) payload;
        logger.info("Received : " + msg.getValue());
    }

    /**
     * A sample message instance.
     * @return instance of <code>Message</code>
     */
    public ECGSignalValue getSampleMessage() {
        ECGSignalValue msg = new ECGSignalValue();
        msg.setValue(999);
        return msg;
    }
}
