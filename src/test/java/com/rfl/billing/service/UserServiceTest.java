package com.rfl.billing.service;

import com.rfl.billing.exception.NotFoundException;
import com.rfl.billing.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.List;

import static com.rfl.billing.UserTestData.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:database/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class UserServiceTest {

    private UserService service;

    @Autowired
    public UserServiceTest(UserService service) {
        this.service = service;
    }

    @Test
    void create() {
        User created = service.create(getNew());
        int newId = created.id();
        User newUser = getNew();
        newUser.setId(newId);
        USER_MATCHER.assertMatch(created, newUser);
        USER_MATCHER.assertMatch(service.get(newId), newUser);
    }
    @Test
    void delete() {
        service.delete(USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(USER_ID));
    }

    @Test
    void get() {
        User actual = service.get(ADMIN_ID);
        USER_MATCHER.assertMatch(actual, admin);
    }

    @Test
    void getByEmail() {
        User actual = service.getByEmail(admin.getEmail());
        USER_MATCHER.assertMatch(actual, admin);
    }

    @Test
    void getAll() {
        List<User> actual = service.getAll();
        USER_MATCHER.assertMatch(actual, admin, user);
    }

    @Test
    void update() {
        User updated = getUpdated();
        service.update(updated);
        USER_MATCHER.assertMatch(service.get(USER_ID), getUpdated());
    }
}