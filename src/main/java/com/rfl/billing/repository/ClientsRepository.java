package com.rfl.billing.repository;

import com.rfl.billing.model.ClientCard;
import com.rfl.billing.repository.crud.CrudClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClientsRepository {
    private CrudClientRepository repository;

    @Autowired
    public ClientsRepository(CrudClientRepository repository) {
    }

    //null if not found
    public ClientCard get(int id) {
        return repository.findById(id).orElse(null);
    }

    // Ordered name asc
    public List<ClientCard> getAll() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(ClientCard::getName))
                .collect(Collectors.toList());
    }

    // false if not found
    public boolean delete(int id) {
        return repository.deleteById(id) != 0;
    }

    @Transactional
    public ClientCard save(ClientCard clientCard) {
        return repository.save(clientCard);
    }
}
