package pl.kompikownia.blog.aspect.timemeasurement.businesslogic;

import pl.kompikownia.blog.aspect.timemeasurement.api.UserData;

public interface ServiceBusinessLogic {
    void fastestService();
    void fastService();
    void slowService();
    void verySlowService();
    void addUser(UserData user);
}
