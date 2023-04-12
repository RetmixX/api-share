package com.example.share.repositories;

import com.example.share.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findByEmail(String email);
    Optional<User> findByToken(String token);
}
