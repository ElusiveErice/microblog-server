package com.csu.microblog.web.Controller;

import com.csu.microblog.biz.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    public String hello(){
        return testService.hello();
    }


    @PostMapping("/img")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        if (file.isEmpty()) {
            return "上传失败没有图片";
        }
        //文件名称
        String fileName = file.getOriginalFilename();
        //允许上传文件名的后缀
        List<String> FILE_WHILE_EXT_LIST = Arrays.asList("JPG","PNG","JPEG","GIF");
        Assert.notNull(fileName,"File name can not be empty");
        String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (FILE_WHILE_EXT_LIST.contains(fileExtName.toUpperCase())){
            //上传文件的位置
            String path = ResourceUtils.getURL("classpath:").getPath()+"static/portrait/";
            //全路径 E:/liangd/Java/stmg-front/src/main/webapp/upload/1.jpg
            File dest = new File(path + fileName);
            //数据库保存地址 /upload/1.jpg
            String imgPath = path + fileName;
            try {
                file.transferTo(dest);
                return "图片路径"+imgPath;
            } catch (IOException e) {
                System.out.println(e);
                return "上传失败异常";
            }
        }
        return "图片格式不正确";
    }
}
