/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.wssignalorigin.SignalOrigin.reader;


import com.example.wssignalorigin.SignalOrigin.exception.SignalException;
import com.example.wssignalorigin.SignalOrigin.signal.values.ECGSignalValue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe
 */
@Service
public class ECGSignalReaderFromFile implements ECGSignalReader{
    private ArrayList<Integer> samples=new ArrayList<>();
    private Integer frequency=0;
    private Boolean foundFrequency=false;
    private Long pId=null;

    public ECGSignalReaderFromFile() {
    }

    private ECGSignalReaderFromFile(Long pId) {
        this();
        this.pId=pId;
    }
    
    @Override
    public ECGSignalValue getSignal() throws SignalException {
        if(pId==null){
            throw new SignalException("No se ha autenticado el usuario");
        }
        ECGSignalValue ans= new ECGSignalValue();
        if(samples.isEmpty()){
            try {
                FileReader fr = new FileReader("resources\\samples.txt");
                BufferedReader textReader = new BufferedReader(fr);
                String line;
                while((line = textReader.readLine()) != null){
                    if(!"".equals(line.trim())){
                        if(!foundFrequency){
                            frequency=Integer.parseInt(line);
                            foundFrequency=true;
                        }else{
                            samples.add(Integer.parseInt(line));
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ECGSignalReaderFromFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ECGSignalReaderFromFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ans.setValue(samples.get(0));
        samples.add(samples.remove(0));
        return ans;
    }

    @Override
    public ECGSignalReader getInstance(Long pId) {
        return new ECGSignalReaderFromFile(pId);
    }
}
