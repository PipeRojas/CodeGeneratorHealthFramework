/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wssignalorigin.SignalOrigin.services;

import com.example.wssignalorigin.SignalOrigin.exception.SignalException;
import com.example.wssignalorigin.SignalOrigin.signal.values.ECGSignalValue;

/**
 *
 * @author Andrés Felipe
 */
public interface SignalServices {
    public ECGSignalValue getSignal(Long pId) throws  SignalException;
}
