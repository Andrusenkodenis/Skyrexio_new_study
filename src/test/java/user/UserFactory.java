package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("swaglabs.admin_user"),
                PropertyReader.getProperty("swaglabs.password"));
    }

    public static User withLockedPermission() {
        return new User(PropertyReader.getProperty("swaglabs.locked_user"),
                PropertyReader.getProperty("swaglabs.password"));
    }
}
