package com.limz.cloud.eurekaclient2.versionConfig;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.Mapping;


/**
 * Api 版本号， 默认1.0
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {

    /**
     * 主要版本，默认 1
     * @return
     */
    @AliasFor("value")
    int major() default 1;

    @AliasFor("major")
    int value() default 1;


    /**
     * 次要版本，默认 0
     * @return
     */
    int minor() default 0;
}