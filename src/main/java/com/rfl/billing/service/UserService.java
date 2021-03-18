package com.rfl.billing.service;

import com.rfl.billing.model.User;
import com.rfl.billing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.rfl.billing.ValidationUtil.checkNotFound;
import static com.rfl.billing.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }
    public void delete(int id){
        checkNotFoundWithId(repository.delete(id), id);
    }
    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }
    public User getByEmail(String email) {
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }
    public List<User> getAll() {
        return repository.getAll();
    }
    public void update(User user) {
        checkNotFoundWithId(repository.save(user), user.getId());
    }

}
