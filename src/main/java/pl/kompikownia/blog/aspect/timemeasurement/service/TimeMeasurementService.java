package pl.kompikownia.blog.aspect.timemeasurement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
