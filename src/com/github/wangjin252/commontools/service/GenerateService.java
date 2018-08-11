package com.github.wangjin252.commontools.service;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class GenerateService {

    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
    private String basePath;
    private String basePackage;
    private String modelName;

    public GenerateService(String basePath, String basePackage, String modelName) {
        this.basePath = basePath;
        this.basePackage = basePackage;
        this.modelName = modelName;
    }

    public void generate(String outputFolder, String templateName) throws Exception {

        Map<String, String> classProperties = new HashMap<>();
        classProperties.put("packageName", basePackage + "." + outputFolder);
        classProperties.put("basePackage", basePackage);
        classProperties.put("modelName", modelName);

        render(outputFolder, classProperties, templateName + ".ftl", templateName.toUpperCase().charAt(0) + templateName.substring(1));
    }

    private void render(String outputFolder, Map<String, String> classProperties, String templateName, String fileSubfix) throws IOException, TemplateException {

        cfg.setTemplateLoader(new ClassTemplateLoader(GenerateService.class, "/templates"));
        Template template = cfg.getTemplate(templateName);


        File file = new File(basePath + "/" + outputFolder);
        if (!file.exists()) {
            file.mkdirs();
        }
        String outputFile = modelName + fileSubfix + ".java";

        Writer out = new OutputStreamWriter(new FileOutputStream(basePath + "/" + outputFolder + "/" + outputFile), StandardCharsets.UTF_8);
        template.process(classProperties, out);
    }
}
