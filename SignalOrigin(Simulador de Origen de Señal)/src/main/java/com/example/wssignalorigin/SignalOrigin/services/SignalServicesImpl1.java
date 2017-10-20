/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wssignalorigin.SignalOrigin.services;


import com.example.wssignalorigin.SignalOrigin.exception.SignalException;
import com.example.wssignalorigin.SignalOrigin.reader.ECGSignalReader;
import com.example.wssignalorigin.SignalOrigin.reader.ECGSignalReaderFromFile;
import com.example.wssignalorigin.SignalOrigin.signal.values.ECGSignalValue;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe
 */
@Service
public class SignalServicesImpl1 implements SignalServices{

    private HashMap<Long, ECGSignalReader> readers=new HashMap<>();
    

    private ECGSignalReader ECGSignalReader= new ECGSignalReaderFromFile();
    
    @Override
    public ECGSignalValue getSignal(Long pId) throws SignalException{
        if(!readers.containsKey(pId)){
            readers.put(pId, ECGSignalReader.getInstance(pId));
        }
        //Se lee la señal
        ECGSignalValue ans=readers.get(pId).getSignal();
        return ans;
    }
}
