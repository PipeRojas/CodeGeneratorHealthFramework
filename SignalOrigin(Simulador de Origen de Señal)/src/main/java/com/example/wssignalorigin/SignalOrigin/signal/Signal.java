/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wssignalorigin.SignalOrigin.signal;

import com.example.wssignalorigin.SignalOrigin.exception.SignalException;
import com.example.wssignalorigin.SignalOrigin.signal.values.SignalValue;



/**
 *
 * @author Andrés Felipe
 */
public interface Signal {
    public SignalValue nextValue() throws SignalException;
    public void addValue(SignalValue s) throws SignalException;
    public Integer getFrequency();
    public void setFrequency(Integer f);
    public Long getpId();
    public void setpId(Long pId);
}
