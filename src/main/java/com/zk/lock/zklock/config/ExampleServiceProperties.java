package com.zk.lock.zklock.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author andyFan
 * @since 2019年01月14日
 */
@ConfigurationProperties("example.service")
public class ExampleServiceProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
