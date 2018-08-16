package com.github.wangjin252.commontools.entity;

public class PackageInfo {

    private String basePackage;

    private String controllerPackge;

    private String servicePackage;

    private String repositoryPackage;

    private String entityPackage;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getControllerPackge() {
        return controllerPackge;
    }

    public void setControllerPackge(String controllerPackge) {
        this.controllerPackge = controllerPackge;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getRepositoryPackage() {
        return repositoryPackage;
    }

    public void setRepositoryPackage(String repositoryPackage) {
        this.repositoryPackage = repositoryPackage;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }
}
