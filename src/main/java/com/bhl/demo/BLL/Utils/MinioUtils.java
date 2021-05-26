package com.bhl.demo.BLL.Utils;

import io.minio.MinioClient;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@RestController
@RequestMapping("/minio/")
public class MinioUtils {

    private static String url = "http://localhost:9000";  //minio服务的IP端口
    private static String accessKey = "minioadmin";
    private static String secretKey = "minioadmin";

    public static MinioClient minioClient;

    //上传文件到minio服务
    public static String upload(MultipartFile file)  {
        try {
            minioClient = new MinioClient(url, accessKey, secretKey);
            InputStream is= file.getInputStream(); //得到文件流
            String fileName = file.getOriginalFilename(); //文件名
            String contentType = file.getContentType();  //类型
            minioClient.putObject("images",fileName,is,contentType); //把文件放置Minio桶(文件夹)
            return  "上传成功";
        }catch (Exception e){
            return "上传失败";
        }
    }
    //下载minio服务的文件
    @GetMapping("download")
    public static String download(HttpServletResponse response){
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            InputStream fileInputStream = minioClient.getObject("file", "test.jpg");
            response.setHeader("Content-Disposition", "attachment;filename=" + "test.jpg");
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            IOUtils.copy(fileInputStream,response.getOutputStream());
            return "下载完成";
        }catch (Exception e){
            return "下载失败";
        }
    }
    //获取minio文件的下载地址
    @GetMapping("url")
    public static String getUrl(){
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            String url = minioClient.presignedGetObject("images", "1.jpg");
            return url;
        }catch (Exception e){
            return "获取失败";
        }
    }
}
