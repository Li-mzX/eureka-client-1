package com.limz.cloud.eurekaclient2.versionConfig;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+.\\d+.\\d+)/");

    private int majorVersion;
    private int minorVersion;

    public ApiVersionCondition(int majorVersion,int minorVersion) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
    }

    public ApiVersionCondition combine(ApiVersionCondition other) {
        return new ApiVersionCondition(other.getMajorVersion(),other.getMinorVersion());
    }

    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getRequestURI());
        if (m.find()) {
            String version = m.group(1);
            Integer major = Integer.valueOf(version.substring(0,version.indexOf(".")));
            Integer minor = Integer.valueOf(version.substring(version.indexOf(".") + 1,version.indexOf(".",2)));
            if (major >= this.majorVersion && minor >= this.minorVersion) // when applying version number bigger than configuration, then it will take
                return this;
        }
        return null;
    }

    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        int ct;
        return  (ct = other.getMajorVersion() - this.majorVersion) == 0 ? other.getMinorVersion() - this.minorVersion : ct ;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }
}