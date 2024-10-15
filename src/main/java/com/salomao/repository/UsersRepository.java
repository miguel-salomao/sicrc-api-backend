package com.salomao.repository;

import com.salomao.model.UsersModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsersRepository implements PanacheRepository<UsersModel> {
    public UsersModel findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public UsersModel findByName(String name){
        return find("name", name).firstResult();
    }
}
