package main_stream.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** StopStreamController RestController class used to stop streaming by setting the flag to false */
@CrossOrigin("http://localhost:4200")
@RestController
public class StopStreamController {

    @GetMapping(value = "/stop")
    public static void stopStreaming(){
        StartStreamController.flag=false;

    }//end of stopStreaming method
}//end of StopStreamController class


