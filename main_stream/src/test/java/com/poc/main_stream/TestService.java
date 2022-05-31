package com.poc.main_stream;

import com.poc.main_stream.controllers.StartStreamController;
import com.poc.main_stream.controllers.StopStreamController;
import com.poc.main_stream.model.TempBpMonitorModel;
import com.poc.main_stream.service.StartStreamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService extends MainStreamApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    TempBpMonitorModel tempBpMonitorModel;

    @Autowired
    StartStreamService startStreamService;

    @Autowired
    StartStreamController startStreamController;

    @Test
    public void testStartStreamService() throws Exception{
        Thread thread=new Thread(startStreamService);
        thread.start();
        thread.interrupt();
        assertTrue(thread.isInterrupted());

        try{
            startStreamController.startStreaming();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//end of try catch
        int count=0;
        while (StartStreamController.flag) {
            assertTrue(tempBpMonitorModel.getTemperature() >= 90 && tempBpMonitorModel.getTemperature() <= 100);
            assertTrue(tempBpMonitorModel.getBp() >= 100 && tempBpMonitorModel.getBp() <= 160);
            count++;
            if (count==1000){
                StopStreamController.stopStreaming();
            }
            else{
                try{
                    startStreamController.startStreaming();
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }//end of try catch
            }//end of if-else
        }//end of while
    }//end of testStartStreamService method
}//end of TestingMainStreamApplication class


