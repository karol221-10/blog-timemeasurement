package pl.kompikownia.blog.aspect.timemeasurement.businesslogic;

import lombok.val;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PermissionCheckerImpl implements PermissionChecker{
    @Override
    public boolean checkPermission(String[] requiredPermissions) {
        // simulate permission checking
        if (Arrays.asList(requiredPermissions).contains("CAN_RUN_SERVICE")) {
            return true;
        }
        return false;
    }
}
