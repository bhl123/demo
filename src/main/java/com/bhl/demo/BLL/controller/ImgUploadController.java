package com.bhl.demo.BLL.controller;

import com.bhl.demo.BLL.Utils.MinioUtils;
import org.apache.catalina.util.RequestUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/upload/")
public class ImgUploadController {

    @Autowired
    private MinioUtils minioUtils;

    @PostMapping("Images")
    public void uploadImages(@RequestBody MultipartFile files, HttpServletRequest request){
        if(ServletFileUpload.isMultipartContent(request)){
            MultipartHttpServletRequest multipartRequest =
                    WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            MultipartFile file = multipartRequest.getFile("file");
            System.out.println("====>>>"+file.getOriginalFilename());
            String a = minioUtils.upload(file);
            System.out.println(a);
        }
    }
}
