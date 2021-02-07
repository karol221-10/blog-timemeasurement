 package pl.kompikownia.blog.aspect.timemeasurement.businesslogic;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import pl.kompikownia.blog.aspect.timemeasurement.api.UserData;

import java.util.Random;

@Component
public class ServiceBusinessLogicImpl implements ServiceBusinessLogic {
    @SneakyThrows
    @Override
    public void fastestService() {
        Thread.sleep(500 + randAdditionalTime());
    }

    @SneakyThrows
    @Override
    public void fastService() {
        Thread.sleep(2500 + randAdditionalTime());
    }

    @SneakyThrows
    @Override
    public void slowService() {
        Thread.sleep(5000 + randAdditionalTime());
    }

    @SneakyThrows
    @Override
    public void verySlowService() {
        Thread.sleep(10000 + randAdditionalTime());
    }

    private int randAdditionalTime() {
        Random random = new Random();
        return random.nextInt(1500);
    }

    @Override
    public void addUser(UserData user) {
        // addUserLogic
    }
}
