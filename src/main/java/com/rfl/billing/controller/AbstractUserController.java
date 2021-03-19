package com.rfl.billing.controller;

import com.rfl.billing.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public abstract class AbstractUserController {
    @Autowired
    UserService service;
}
