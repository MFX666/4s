package com.hmf.server.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.hmf.server.controller.BaseController;

import java.util.Collections;

public class PracticeApplication {
    public static void main(String[] args) {
//        代码生成器
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/4s?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "123")
                .globalConfig(builder -> {
                    builder.author("mfx") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                            .commentDate("yyyy-MM-dd")
                            .outputDir("F:\\桌面文档\\毕业设计\\后端代码\\4s\\src\\main\\java"); // 指定输出目录

                })
                .packageConfig(builder -> {
                    builder.parent("com.hmf.server") // 设置父包名
//                            .moduleName("server") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "F:\\桌面文档\\毕业设计\\后端代码\\4s\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_position") // 设置需要生成的表名
                            .addTablePrefix("t_")
                            .controllerBuilder().enableRestStyle().superClass(BaseController.class)
                            .entityBuilder().enableLombok().columnNaming(NamingStrategy.no_change); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
