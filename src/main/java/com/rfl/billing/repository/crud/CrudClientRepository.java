package com.rfl.billing.repository.crud;

import com.rfl.billing.model.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudClientRepository extends JpaRepository<ClientCard, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM ClientCard card WHERE card.id=:id")
    int deleteById(@Param("id") int id);
}
