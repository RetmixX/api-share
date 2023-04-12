package com.example.share.repositories;

import com.example.share.models.Folder;
import com.example.share.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderRepository extends CrudRepository<Folder, Integer> {
    List<Folder> findByUser(User user);

    Optional<Folder> findByFolderId(String folderId);

}