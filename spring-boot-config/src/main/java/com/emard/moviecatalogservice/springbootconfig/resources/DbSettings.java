package com.emard.moviecatalogservice.springbootconfig.resources;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("db")
@Configuration
public class DbSettings {
    private String connection;
    private String host;
    private Integer port;
    


    public String getConnection() {
        return this.connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}