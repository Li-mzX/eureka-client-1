package com.limz.cloud.eurekaclient2.v2.controller;


import com.limz.cloud.eurekaclient2.versionConfig.ApiVersion;
import org.springframework.web.bind.annotation.RestController;

@ApiVersion(2)
@RestController("hello2.0")
public class HelloController2 extends com.limz.cloud.eurekaclient2.v1.controller.HelloController {

    public String bye(){

        return "bye v2.0";
    }
}
