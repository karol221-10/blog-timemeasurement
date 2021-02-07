package pl.kompikownia.blog.aspect.timemeasurement.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kompikownia.blog.aspect.timemeasurement.service.TimeMeasurementService;

@RestController
@RequiredArgsConstructor
public class TimeMeasurementRestController {

    private final TimeMeasurementService timeMeasurementService;

    @PostMapping("/api/service/slow")
    public void startSlowService() {
        timeMeasurementService.slowService();
    }

    @PostMapping("/api/service/veryslow")
    public void startVerySlowService() {
        timeMeasurementService.verySlowService();
    }

    @PostMapping("/api/service/fast")
    public void startFastService() {
        timeMeasurementService.fastService();;
    }

    @PostMapping("/api/service/fastest")
    public void startFastestService() {
        timeMeasurementService.fastestService();
    }
}
