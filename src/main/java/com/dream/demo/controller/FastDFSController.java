package com.dream.demo.controller;

import com.dream.demo.service.IFastDFSService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@RestController
public class FastDFSController {
    private Logger logger = LoggerFactory.getLogger(FastDFSController.class);

    @Autowired
    private IFastDFSService fastDFSService;

    /**
     * 上传文件
     *
     * @param files
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestPart("files") MultipartFile[] files) {
        String url = "";
        try {
            url = fastDFSService.uploadFile(files);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 文件下载
     *
     * @param fileUrl  url 开头从组名开始
     * @param response
     * @throws Exception
     */
    @RequestMapping("/download")
    public void download(@RequestParam("fileUrl") String fileUrl, HttpServletResponse response) throws Exception {

        byte[] data = fastDFSService.downloadFile(fileUrl);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("test.jpg", "UTF-8"));
        // 写出
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.write(data, outputStream);
    }

    /**
     * 删除文件
     * 示例：group1/M00/00/00/wKj0gl02aeqAKqoAAABWsOuJo1w347.jpg
     * @param fileUrl
     * @return
     */
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    public void deleteFile(@RequestParam("fileUrl") String fileUrl) {
        try {
            fastDFSService.deleteFile(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件信息
     *  示例入参：groupName:group1，path:M00/00/00/wKj0gl0xijOABpueAABlGHvbGSg492.jpg
     * @param groupName
     * @param fileUrl
     * @return
     */
    @RequestMapping(value = "/getFile", method = RequestMethod.POST)
    public void getFile(@RequestParam("groupName") String groupName, @RequestParam("fileUrl") String fileUrl) {
        try {
            fastDFSService.getFile(groupName, fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件元信息
     *
     * @param groupName
     * @param fileUrl
     * @return
     */
    @RequestMapping(value = "/getMetadata", method = RequestMethod.POST)
    public void getMetadata(@RequestParam("groupName") String groupName, @RequestParam("fileUrl") String fileUrl) {
        try {
            fastDFSService.getMetadata(groupName, fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
