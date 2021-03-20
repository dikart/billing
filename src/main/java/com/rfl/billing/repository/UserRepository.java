package com.rfl.billing.repository;

import com.rfl.billing.model.User;
import com.rfl.billing.repository.crud.CrudUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");

    CrudUserRepository repo;

    @Autowired
    public UserRepository(CrudUserRepository repo) {
        this.repo = repo;
    }

    // null if not found
    public User get(int id) {
        Optional<User> user = repo.findById(id);
        return user.orElse(null);
    }

    //Sorted by name and email asc
    public List<User> getAll() {
        return repo.findAll(SORT_NAME_EMAIL);
    }

    //false if not successful
    public boolean delete(int id) {
        return repo.deleteById(id) != 0;
    }

    //null if not found
    public User getByEmail(String email) {
        return repo.getFirstByEmail(email).orElse(null);
    }

    @Transactional
    public User save(User user) {
        return repo.save(user);
    }
}
