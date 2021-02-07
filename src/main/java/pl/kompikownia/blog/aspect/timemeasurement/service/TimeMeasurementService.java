package pl.kompikownia.blog.aspect.timemeasurement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kompikownia.blog.aspect.timemeasurement.api.UserData;
import pl.kompikownia.blog.aspect.timemeasurement.businesslogic.ServiceBusinessLogic;

@RequiredArgsConstructor
@Component
public class TimeMeasurementService {

    private final ServiceBusinessLogic serviceBusinessLogic;

    public void fastestService() {
        serviceBusinessLogic.fastestService();
    }

    public void fastService() {
        serviceBusinessLogic.fastService();
    }

    public void slowService() {
        serviceBusinessLogic.slowService();
    }

    public void verySlowService() {
        serviceBusinessLogic.verySlowService();
    }

    public void addUser(UserData userData) {
        serviceBusinessLogic.addUser(userData);
    }

    public Integer runVeryComplicatedOperation(String arg1, Integer arg2) {
        // do something with arg1 and arg2
        return serviceBusinessLogic.calculateResult();
    }
}
