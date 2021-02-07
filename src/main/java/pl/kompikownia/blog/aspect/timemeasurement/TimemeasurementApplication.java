package pl.kompikownia.blog.aspect.timemeasurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TimemeasurementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimemeasurementApplication.class, args);
    }

}
