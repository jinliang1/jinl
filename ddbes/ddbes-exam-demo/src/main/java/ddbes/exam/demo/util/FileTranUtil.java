package ddbes.exam.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.utils
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/13 13:51
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Slf4j
public class FileTranUtil {
    /**
     * 上传单个文件
     */
    public static String uploadFile(MultipartFile uploadfile, String dir) {
        log.info("Single file upload!");
        if (uploadfile.isEmpty()) {
            return "文件夹不能为空";
        }
        try {
            saveUploadedFiles(Arrays.asList(uploadfile), dir);
        } catch (IOException e) {
            e.printStackTrace();
            return "后台服务异常";
        }
        log.info("file upload successfully !" + dir);
        return "文件上传成功";
    }

    /**
     * 多文件上传
     * dir  保存目录
     */
    public static String uploadFiles(MultipartFile[] uploadfiles, String dir) {
        log.debug("Multiple file upload");
        String uploadFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining("  ,  "));
        if (StringUtils.isEmpty(uploadFileName)) {
            return "文件名不能为空";
        }
        try {
            FileTranUtil.saveUploadedFiles(Arrays.asList(uploadfiles), dir);
        } catch (IOException e) {
            return "后台服务器异常";
        }
        log.info("file upload successfully" + uploadFileName);
        return "文件上传成功";
    }

    /**
     * 保存到文件的指定路径
     */
    public static void saveUploadedFiles(List<MultipartFile> files, String dir) throws IOException {
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename().replace("\\", "/");
            if (fileName.lastIndexOf('/') > 0) {
                //上传文件遇到这种情况
                String fileDir = dir + "/" + fileName.substring(0, fileName.lastIndexOf('/'));
            }
            Path path = Paths.get(dir + "/" + fileName);
            Files.write(path, bytes);
        }

    }

    /**
     * 根据文件路径下载 文件
     */
    public static ResponseEntity<InputStreamResource> downloadFile(String filePath) throws IOException {
        log.info("downloading file : " + filePath);

        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", new String(file.getFilename()
                .getBytes("gbk"), "iso-8859-1")));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        System.out.println(file.getFilename());
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
