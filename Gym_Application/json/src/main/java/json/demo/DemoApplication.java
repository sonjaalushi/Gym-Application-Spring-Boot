package json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.demo.dto.Root;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public DemoApplication() throws IOException {
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    ObjectMapper om = new ObjectMapper();

    // Element Example

    Root root = om.readValue(new File("C:\\Users\\User\\Desktop\\json\\src\\main\\resources\\data\\sample2.json"), Root.class);

}
