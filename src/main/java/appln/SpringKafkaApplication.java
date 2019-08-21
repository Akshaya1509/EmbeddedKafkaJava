package appln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import service.Receiver;
import service.MySender;

@SpringBootApplication
@ComponentScan(basePackageClasses = {MySender.class, Receiver.class})
public class SpringKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }
}