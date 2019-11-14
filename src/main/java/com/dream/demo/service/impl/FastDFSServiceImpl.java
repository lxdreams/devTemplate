package com.dream.demo.service.impl;

import com.dream.demo.service.IFastDFSService;
import com.dream.demo.util.FastDFSClientWrapper;
import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.MataData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class FastDFSServiceImpl implements IFastDFSService {

    private final Logger logger = LoggerFactory.getLogger(FastDFSClientWrapper.class);

    @Autowired
    private FastDFSClientWrapper dfsClient;

    @Override
    public String uploadFile(MultipartFile[] multipartFiles) {
        String url = "";
        for (MultipartFile file : multipartFiles) {
            try {
                url = dfsClient.uploadFile(file);
                logger.info("上传文件名{}，返回地址{}", file.getOriginalFilename(), url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    @Override
    public byte[] downloadFile(String fileUrl) {
        logger.info("图片地址{}", fileUrl);
        byte[] bytes = null;
        try {
            bytes = dfsClient.downloadFile(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    @Override
    public void deleteFile(String fileUrl) {
        try {
            dfsClient.deleteFile(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileInfo getFile(String groupName, String path) {
        FileInfo fileInfo = new FileInfo();
        try {
            fileInfo = dfsClient.getFile(groupName, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileInfo;
    }

    @Override
    public Set<MataData> getMetadata(String groupName, String path) {
        Set<MataData> mataData = new HashSet<>();
        try {
            mataData = dfsClient.getMetadata(groupName, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mataData;
    }

    @Override
    public String uploadImageAndCrtThumbImage(MultipartFile[] multipartFiles) {
        String url = "";
        for (MultipartFile file : multipartFiles) {
            try {
                url = dfsClient.uploadImageAndCrtThumbImage(file);
                logger.info("上传文件名{}，返回地址{}", file.getOriginalFilename(), url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return url;
    }
}
