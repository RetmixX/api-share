package com.example.share.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/folders/{idFolder}/files")
public class FileController {
    @PostMapping
    public ResponseEntity<?> uploadFile(@PathVariable String idFolder,
                                        @RequestParam("file") List<MultipartFile> files,
                                        @RequestParam("folder_id") String folderId){
        return null;
    }
    @PatchMapping("/{idFile}")
    public ResponseEntity<?> updateFile(@PathVariable String idFolder, @PathVariable String idFile){
        return null;
    }
    @DeleteMapping("/{idFile}")
    public ResponseEntity<?> deleteFile(@PathVariable String idFolder, @PathVariable String idFile){
        return null;
    }

}
