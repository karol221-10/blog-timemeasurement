package pl.kompikownia.blog.aspect.timemeasurement.businesslogic;

public interface PermissionChecker {
    boolean checkPermission(String[] requiredPermissions);
}
