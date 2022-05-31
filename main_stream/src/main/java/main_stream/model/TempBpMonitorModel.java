package main_stream.model;

import org.springframework.stereotype.Component;

/** Model class containing variables temperature and bp of datatype integer in order to store generated values*/
@Component
public class TempBpMonitorModel {
    private int temperature;
    private int bp;

    public TempBpMonitorModel(){

    }
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

}//end of TempBpMonitor class


