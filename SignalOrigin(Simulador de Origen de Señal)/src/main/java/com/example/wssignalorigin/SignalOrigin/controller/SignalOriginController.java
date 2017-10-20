/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wssignalorigin.SignalOrigin.controller;

import com.example.wssignalorigin.SignalOrigin.exception.SignalException;
import com.example.wssignalorigin.SignalOrigin.services.SignalServices;
import com.example.wssignalorigin.SignalOrigin.signal.values.ECGSignalValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrés Felipe
 */


@RestController
@RequestMapping(value = "/signal")
public class SignalOriginController {
    @Autowired
    SignalServices ss;
    
    @MessageMapping("/begin/{pId}")
    @SendTo("/topic/signal")
    public ECGSignalValue sendECGsignal(@DestinationVariable Long pId) throws InterruptedException, SignalException {
        ECGSignalValue ans=(ECGSignalValue) ss.getSignal(pId);
        return ans;
    }
}
