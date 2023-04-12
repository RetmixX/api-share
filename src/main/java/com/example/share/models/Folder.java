package com.example.share.models;

import com.example.share.requests.folders.CreateOrUpdateFolderRequest;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "folders")
public class Folder extends BaseModel{
    @Column(name = "folder_id")
    private String folderId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Folder folder;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<Folder> innerFolders;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<File> filesInFolder;
    public Folder() {
    }

    public Folder(CreateOrUpdateFolderRequest data, Folder folder, User user, String folderId){
        this.folderId = folderId;
        this.name = data.name();
        this.user = user;
        this.folder = folder;

    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Folder getFolder() {
        return folder;
    }

    public List<Folder> getInnerFolders() {
        return innerFolders;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public List<File> getFilesInFolder() {
        return filesInFolder;
    }

    public User getUser() {
        return user;
    }

    public void addInnerFolder(Folder folder){
        if (this.innerFolders == null){
            this.innerFolders = new ArrayList<>();
        }

        this.innerFolders.add(folder);
    }

    public void removeInnerFolder(Folder folder){
        this.innerFolders.remove(folder);
    }
}
