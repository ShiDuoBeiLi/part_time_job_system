package com.votre.interceptor;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer{
    //将jar文件下的对应静态资源文件路径对应到磁盘的路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        String dirPath;
        if(jarF.length() == 0){
            dirPath = "no";
        }
         dirPath = jarF.getParentFile().toString()+"/upload/";

        String os = System.getProperty("os.name");

        System.out.println("os"+os);

        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/upload/**").addResourceLocations("file:"+dirPath);
            System.out.println("file:" + dirPath);

        } else {
            registry.addResourceHandler("/upload/**").addResourceLocations("file:"+dirPath);
            System.out.println("file:" + dirPath);
        }
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
