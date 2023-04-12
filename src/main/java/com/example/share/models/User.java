package com.example.share.models;

import com.example.share.requests.users.RegistrationRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User extends BaseModel{
    private String name;
    private String surname;
    private String email;
    private String password;

    private String token;

    @OneToMany(mappedBy = "user")
    private List<Folder> foldersUser;

    @OneToMany(mappedBy = "user")
    private List<File> userFiles;

    public User() {
    }

    public User(RegistrationRequest data, String hashPassword){
        this.name = data.first_name();
        this.surname = data.last_name();
        this.email = data.email();
        this.password = hashPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Folder> getFoldersUser() {
        return foldersUser;
    }

    public List<File> getUserFiles() {
        return userFiles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void addFile(File file){
        if (this.userFiles == null){
            this.userFiles = new ArrayList<>();
        }

        this.userFiles.add(file);
    }
}
