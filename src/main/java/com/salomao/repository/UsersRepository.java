package com.salomao.repository;

import com.salomao.model.UsersModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

@ApplicationScoped
public class UsersRepository implements PanacheRepository<UsersModel> {

    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    public UsersModel findByEmail(String email) {
        logger.info("Getting user by email " + email);
        return find("email", email).firstResult();
    }

    public UsersModel findByName(String name){
        logger.info("Getting user by name " + name);
        return find("name", name).firstResult();
    }

    public UsersModel findById(Long id){
        logger.info("Getting user by id " + id);
        return find("id", id).firstResult();
    }


}
