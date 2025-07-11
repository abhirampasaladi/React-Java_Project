package org.project.ew_backend.service;

import org.project.ew_backend.model.UserDB;
import org.project.ew_backend.repository.JPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {
    private final JPARepo jpaRepo;

    @Autowired
    public CrudService(JPARepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    public void updateDB(UserDB userDB) {
        jpaRepo.save(userDB);
    }

    public List<UserDB> usersList() {
        return jpaRepo.findAll();
    }

    public UserDB getUserInfo(String username) {
        return jpaRepo.findById(username).orElse(null);
    }

}
