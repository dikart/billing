package com.rfl.billing.repository.crud;

import com.rfl.billing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    Optional<User> getFirstByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int deleteById(@Param("id") int id);
}
