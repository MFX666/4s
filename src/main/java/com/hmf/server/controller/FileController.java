package com.hmf.server.controller;

import cn.hutool.http.HttpResponse;
import com.hmf.server.model.ResponseBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author humengfan
 * @since 2022年10月02日 17:22
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public ResponseBean uploadFile(MultipartFile file) throws Exception {
        try {
            /*
            1、存放路径
            2、生成文件绝对路径
            3、
             */

            String filePath = "F:/code/static/4s/";


            String ext=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));

            String filename= filePath+UUID.randomUUID().toString()+ext;

            file.transferTo(new File(filename));
            return  ResponseBean.success(filename);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return ResponseBean.error("上传失败");
    }

    @GetMapping("/download")
    @ResponseBody
    public void downloadFile(String filename, HttpServletResponse response) {
        File file = null;
        try{
            file = new File(filename);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            //获取图片格式
            String formatName=file.getName()
                    .substring(file.getName()
                            .indexOf(".")+1);
            BufferedImage read = ImageIO.read(file);
            // 将图片写入响应流
            ImageIO.write(read,formatName , response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
