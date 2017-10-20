package com.example.wssignalorigin.SignalOrigin;


import com.example.wssignalorigin.SignalOrigin.exception.SignalException;
import com.example.wssignalorigin.SignalOrigin.services.SignalServices;
import com.example.wssignalorigin.SignalOrigin.services.SignalServicesImpl1;
import com.example.wssignalorigin.SignalOrigin.signal.values.ECGSignalValue;
import com.example.wssignalorigin.SignalOrigin.webSocket.MyStompSessionHandler;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;



public class SignalOriginApplication {
        private static WebSocketHttpHeaders headers = new WebSocketHttpHeaders();
	public static void main(String[] args) throws InterruptedException, ExecutionException {
            String auth = "12dea96fec20593566ab75692c9949596833adc9" + ":" + "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8";
            headers.add("Authorization", "Basic " + new String(Base64.getEncoder().encode(auth.getBytes())));
            WebSocketClient simpleWebSocketClient = new StandardWebSocketClient();
            List<Transport> transports = new ArrayList<>(1);
            transports.add((Transport) new WebSocketTransport(simpleWebSocketClient));
            SockJsClient sockJsClient = new SockJsClient(transports);
            WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
            stompClient.setMessageConverter(new MappingJackson2MessageConverter());
            String url = "ws://localhost:8080/signal-in-websocket";
            StompSessionHandler sessionHandler = new MyStompSessionHandler();
            StompSession session = stompClient.connect(url, headers, sessionHandler).get();
            
            session.subscribe("/topic/ECGsignaltoserver" , new StompFrameHandler() {
                @Override
                public Type getPayloadType(StompHeaders headers) {
                    return ECGSignalValue.class;
                }

                @Override
                public void handleFrame(StompHeaders headers,Object payload) {
                    System.out.println(((ECGSignalValue) payload).getValue());
                    System.err.println(payload.toString());
                }
            });
            session.send("/app/saveECGfrequency/123", 250);
            SignalServices signalServices=new SignalServicesImpl1();
            try {
                while(true){
                    Thread.sleep(4);
                    session.send("/app/saveECG/123", signalServices.getSignal(Long.parseLong("123")));
                }
            } catch (SignalException ex) {
                Logger.getLogger(SignalOriginApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}
