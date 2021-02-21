package pl.kompikownia.blog.aspect.timemeasurement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kompikownia.blog.aspect.timemeasurement.annotation.CheckPermission;
import pl.kompikownia.blog.aspect.timemeasurement.api.UserData;
import pl.kompikownia.blog.aspect.timemeasurement.businesslogic.ServiceBusinessLogic;

@RequiredArgsConstructor
@Component
public class TimeMeasurementService {

    private final ServiceBusinessLogic serviceBusinessLogic;

    @CheckPermission("CAN_RUN_SERVICE")
    public void fastestService() {
        serviceBusinessLogic.fastestService();
    }

    @CheckPermission("CAN_RUN_SERVICE")
    public void fastService() {
        serviceBusinessLogic.fastService();
    }

    @CheckPermission("CAN_RUN_SERVICE")
    public void slowService() {
        serviceBusinessLogic.slowService();
    }

    @CheckPermission("CAN_RUN_SERVICE")
    public void verySlowService() {
        serviceBusinessLogic.verySlowService();
    }

    @CheckPermission("CAN_ADD_USER")
    public void addUser(UserData userData) {
        serviceBusinessLogic.addUser(userData);
    }

    @CheckPermission("CAN_RUN_COMPLICATED_OPERATION")
    public Integer runVeryComplicatedOperation(String arg1, Integer arg2) {
        // do something with arg1 and arg2
        return serviceBusinessLogic.calculateResult();
    }
}
