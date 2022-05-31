package com.poc.main_stream;

import com.poc.main_stream.model.TempBpMonitorModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class TestModels {
    @Test
    public void testModel(){
        TempBpMonitorModel tp=new TempBpMonitorModel();
        tp.setTemperature(92);
        tp.setBp(120);
        assertTrue(tp.getTemperature()==92);
        assertTrue(tp.getBp()==120);
    }
}
