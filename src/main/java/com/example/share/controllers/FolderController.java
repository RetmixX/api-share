package com.example.share.controllers;

import com.example.share.requests.folders.CreateOrUpdateFolderRequest;
import com.example.share.responses.SharedResponse;
import com.example.share.responses.folders.FolderCreateResponse;
import com.example.share.services.FolderService;
import com.example.share.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/folders")
public class FolderController {

    private final UserService userService;
    private final FolderService folderService;

    public FolderController(UserService userService, FolderService folderService) {
        this.userService = userService;
        this.folderService = folderService;
    }

    @PostMapping
    public ResponseEntity<FolderCreateResponse> createFolder(@RequestHeader("authorization") String token,
                                                             @Valid @RequestBody CreateOrUpdateFolderRequest data){
        return ResponseEntity.ok(folderService.createFolder(userService.validateRequestToken(token), data));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SharedResponse> updateFolder(@RequestHeader("authorization") String token,
                                                       @Valid @RequestBody CreateOrUpdateFolderRequest data,
                                                       @PathVariable String id){
        folderService.checkPermissionFolder(userService.validateRequestToken(token), id);
        return ResponseEntity.ok(folderService.updateFolder(data, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SharedResponse> deleteFolder(@RequestHeader("authorization") String token,
                                                       @PathVariable String id){
        folderService.checkPermissionFolder(userService.validateRequestToken(token), id);
        return ResponseEntity.ok(folderService.deleteFolder(id));
    }
}
