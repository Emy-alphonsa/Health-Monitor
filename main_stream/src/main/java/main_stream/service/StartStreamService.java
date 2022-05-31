package main_stream.service;

import main_stream.model.TempBpMonitorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import java.util.Random;
import static main_stream.controllers.StartStreamController.flag;


/** StartStreamService class is used to generate random numbers for temperature and bp using a thread.
 * SimpMessagingTemplate is used to send model class data through websocket */
@Service
public class StartStreamService implements Runnable {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    TempBpMonitorModel tempBpMonitor;

    Random random=new Random();

    public void run() {
        while(flag){
            tempBpMonitor.setTemperature(91+random.nextInt(100-90));
            tempBpMonitor.setBp(101+random.nextInt(160-100));
            simpMessagingTemplate.convertAndSend("/msg",tempBpMonitor);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }//end of try-catch block
        }//end of while
    }//end of run method
}//end of StartStreamService

