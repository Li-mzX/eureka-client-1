package com.limz.cloud.eurekaclient2.v1.controller;


import com.limz.cloud.eurekaclient2.versionConfig.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiVersion
@RestController("hello1")
@RequestMapping("/{api-version}")
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){

        return "hello v1";
    }

    @RequestMapping("/bye")
    public String bye(){

        return "bye v1";
    }
}
