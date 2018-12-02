package com.limz.cloud.eurekaclient2.v2.controller;


import com.limz.cloud.eurekaclient2.versionConfig.ApiVersion;
import org.springframework.web.bind.annotation.RestController;

@ApiVersion(major = 2,minor = 2)
@RestController("hello2.1")
public class HelloController21 extends HelloController2 {

    public String bye(){

        return "bye v2.1";
    }
}
