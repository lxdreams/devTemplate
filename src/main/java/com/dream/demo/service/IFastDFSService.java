package com.dream.demo.service;

import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.MataData;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface IFastDFSService {
    String uploadFile(MultipartFile[] multipartFiles);
    byte[] downloadFile(String fileUrl);
    void deleteFile(String fileUrl);
    FileInfo getFile(String groupName, String path);
    Set<MataData> getMetadata(String groupName, String path);
    String uploadImageAndCrtThumbImage(MultipartFile[] multipartFiles);
}
