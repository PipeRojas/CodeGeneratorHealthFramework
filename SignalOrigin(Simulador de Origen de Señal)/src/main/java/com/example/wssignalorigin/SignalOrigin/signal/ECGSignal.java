/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wssignalorigin.SignalOrigin.signal;


import com.example.wssignalorigin.SignalOrigin.exception.SignalException;
import com.example.wssignalorigin.SignalOrigin.signal.values.ECGSignalValue;
import com.example.wssignalorigin.SignalOrigin.signal.values.SignalValue;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Andrés Felipe
 */
public class ECGSignal implements Signal{
    
    private Long pId;
    private List<ECGSignalValue> signals= new ArrayList();
    private Integer frequency=null;

    @Override
    public SignalValue nextValue() throws SignalException{
        ECGSignalValue ans= new ECGSignalValue();
        if(pId==null||frequency==null){
            throw new SignalException("ID de Paciente o Frecuencia de Señal no definidas");
        }else{
            if(!signals.isEmpty()){
                ans=signals.remove(0);
            }else{
                ans.setValue(-1);
            }
        }
        return ans;
    }

    @Override
    public void addValue(SignalValue s) throws SignalException{
        if(pId==null||frequency==null){
            throw new SignalException("ID de Paciente o Frecuencia de Señal no definidas");
        }else{
            if(signals.size()<2000){
                signals.add((ECGSignalValue) s);
            }else{
                signals.remove(0);
                signals.add((ECGSignalValue) s);
            }
        }
    }

    @Override
    public Integer getFrequency() {
        return this.frequency;
    }

    @Override
    public Long getpId() {
        return this.pId;
    }

    @Override
    public void setFrequency(Integer f) {
        this.frequency=f;
    }

    @Override
    public void setpId(Long pId) {
        this.pId=pId;
    }
    
}
