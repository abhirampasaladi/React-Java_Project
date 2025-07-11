package org.project.ew_backend.repository;

import org.project.ew_backend.model.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JPARepo extends JpaRepository<UserDB, String> {
}
