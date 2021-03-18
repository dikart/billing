package com.rfl.billing;

import com.rfl.billing.model.Role;
import com.rfl.billing.model.User;

import java.util.Collections;

import static com.rfl.billing.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final TestMatcher<User> USER_MATCHER = TestMatcher.usingIgnoringFieldsComparator("registered", "roles");

    public static final int ADMIN_ID = START_SEQ;
    public static final int USER_ID = START_SEQ + 1;

    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin",
            Role.ADMIN);
    public static final User user = new User(USER_ID, "User", "user@yandex.ru", "password",
            Role.USER);

    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", Role.USER);
    }

    public static User getUpdated() {
        User updated = new User(user);
        updated.setEmail("update@gmail.com");
        updated.setName("UpdatedName");
        updated.setPassword("newPass");
        updated.setEnabled(false);
        updated.setRoles(Collections.singletonList(Role.ADMIN));
        return updated;
    }

}
