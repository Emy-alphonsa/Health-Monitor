package main_stream.controllers;

import main_stream.service.StartStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** StartStreamController RestController class used to start streaming,
 * by setting the flag of type static to true and then creating a thread having runnable target as reference of StartStreamService class
 * and then starting the thread if it is not alive*/
@CrossOrigin("http://localhost:4200")
@RestController
public class StartStreamController{
    @Autowired
    StartStreamService startStreamService;
    public static boolean flag=true;

    @GetMapping(value = "/start")
    public void startStreaming( ){
        flag=true;
        Thread thread=new Thread(startStreamService);
        if (!thread.isAlive() ) {
            thread.start();
        }
    }//end of startStreaming method
}//end of class StartStreamController

