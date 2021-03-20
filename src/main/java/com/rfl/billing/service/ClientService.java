package com.rfl.billing.service;

import com.rfl.billing.model.ClientCard;
import com.rfl.billing.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.rfl.billing.ValidationUtil.checkNotFoundWithId;

@Service
public class ClientService {
    private ClientsRepository repository;

    @Autowired
    public ClientService(ClientsRepository repository) {
        this.repository = repository;
    }

    public ClientCard create(ClientCard card) {
        return repository.save(card);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public ClientCard get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<ClientCard> getAll() {
        return repository.getAll();
    }

    public ClientCard update(ClientCard card) {
        return checkNotFoundWithId(repository.save(card), card.id());
}
}
