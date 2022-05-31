package bdd_test;

import io.cucumber.spring.CucumberContextConfiguration;
import main_stream.MainStreamApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = MainStreamApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {
}



