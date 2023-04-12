package com.example.share.repositories;

import com.example.share.models.File;
import com.example.share.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends CrudRepository<File, Integer> {
    List<File> findByUser(User user);
}
