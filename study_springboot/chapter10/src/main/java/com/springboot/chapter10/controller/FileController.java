package com.springboot.chapter10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/1/30 17:55
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @GetMapping("/upload/page")
    public String uploadPage() {
        return "file/upload";
    }

    @PostMapping("/upload/request")
    @ResponseBody
    public Map<String, Object> uploadRequest(HttpServletRequest request) {
        MultipartHttpServletRequest mreq = null;
        if (request instanceof MultipartHttpServletRequest) {
            mreq = (MultipartHttpServletRequest) request;
        } else {
            return dealRequestMap(false, "上传失败");
        }
        MultipartFile mf = mreq.getFile("file");
        String filename = mf.getOriginalFilename();
        File file = new File(filename);
        try {
            mf.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
            return dealRequestMap(false, "上传失败");
        }
        return dealRequestMap(true, "上传成功");
    }

    @PostMapping("/upload/multipart")
    @ResponseBody
    public Map<String, Object> uploadMultipartFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
            return dealRequestMap(false, "上传失败");
        }
        return dealRequestMap(true, "上传成功");
    }

    @PostMapping("/upload/part")
    @ResponseBody
    public Map<String, Object> uploadPart(Part file) {
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return dealRequestMap(false, "上传失败");
        }
        return dealRequestMap(true, "上传成功");
    }

    private Map<String, Object> dealRequestMap(boolean success, String msg) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("success", success);
        result.put("msg", msg);
        return result;
    }
}
