package com.example.share.services;

import com.example.share.exceptions.folders.FolderNotFoundError;
import com.example.share.exceptions.users.PermissionError;
import com.example.share.models.Folder;
import com.example.share.models.User;
import com.example.share.repositories.FolderRepository;
import com.example.share.requests.folders.CreateOrUpdateFolderRequest;
import com.example.share.responses.SharedResponse;
import com.example.share.responses.folders.FolderCreateResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class FolderService {
    private final FolderRepository folderRepository;

    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public FolderCreateResponse createFolder(User user, CreateOrUpdateFolderRequest data){
        String folderId = RandomStringUtils.randomAlphabetic(10);
        Folder folderParent;
        if (data.parent_id().equals("0")){
            folderParent = null;
        }
        else {
            folderParent = folderRepository.findByFolderId(data.parent_id())
                    .orElseThrow(FolderNotFoundError::new);
        }

        Folder newFolder = new Folder(data, folderParent, user, folderId);
        folderRepository.save(newFolder);

        return new FolderCreateResponse(true, "Папка создана", newFolder.getFolderId());
    }

    public SharedResponse updateFolder(CreateOrUpdateFolderRequest data, String id){
        Folder updateFolder = folderRepository.findByFolderId(id).orElseThrow(FolderNotFoundError::new);
        updateFolder.setName(data.name());
        if (!data.parent_id().equals("0")){
            updateFolder.setFolder(folderRepository.findByFolderId(data.parent_id())
                    .orElseThrow(FolderNotFoundError::new));
        }

        folderRepository.save(updateFolder);

        return new SharedResponse(true, "Обновлено");
    }

    public SharedResponse deleteFolder(String idFolder){
        Folder deleteFolder = folderRepository.findByFolderId(idFolder).orElseThrow(FolderNotFoundError::new);
        folderRepository.delete(deleteFolder);

        return new SharedResponse(true, "Папка удалена");
    }

    public void checkPermissionFolder(User user, String folderId){
        Folder folder = folderRepository.findByFolderId(folderId).orElseThrow(FolderNotFoundError::new);

        if (!folder.getUser().equals(user)){
            throw new PermissionError("У вас нету прав на эту папку");
        }
    }
}
