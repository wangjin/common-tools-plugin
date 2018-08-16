package com.github.wangjin252.commontools.service;

import com.github.wangjin252.commontools.entity.PackageInfo;
import com.github.wangjin252.commontools.entity.Table;
import com.github.wangjin252.commontools.util.ModelNameFreemakerMethodEx;
import com.github.wangjin252.commontools.util.StringUtil;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateService {

    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

    public GenerateService() {
        cfg.setTemplateLoader(new ClassTemplateLoader(GenerateService.class, "/templates"));
        cfg.setSharedVariable("lowerFirstLetter", new ModelNameFreemakerMethodEx());
        // cfg.setCustomAttribute("lowerFirstLetter", new ModelNameFreemakerMethodEx());
    }

    public void generate(String basePath, PackageInfo packageInfo, List<Table> tables) throws Exception {


        Map<String, Object> classProperties = new HashMap<>();
        classProperties.put("packageInfo", packageInfo);

        for (Table table : tables) {
            classProperties.put("modelName", StringUtil.snakeToCamel(table.getName()));
            classProperties.put("columnList", table.getColumns());

            render(classProperties, "controller", basePath + "/src/main/java/" + StringUtil.packgeToPath(packageInfo.getBasePackage()) + "/" + packageInfo.getControllerPackage(), "Controller", "java");
            render(classProperties, "service", basePath + "/src/main/java/" + StringUtil.packgeToPath(packageInfo.getBasePackage()) + "/" + packageInfo.getServicePackage(), "Service", "java");
            render(classProperties, "repository", basePath + "/src/main/java/" + StringUtil.packgeToPath(packageInfo.getBasePackage()) + "/" + packageInfo.getRepositoryPackage(), "Repository", "java");

        }

    }

    private void render(Map<String, Object> classProperties, String templateName, String outputPath, String fileSubfix, String fileExtension) throws IOException, TemplateException {

        Template template = cfg.getTemplate(templateName + ".ftl");

        File file = new File(outputPath);
        if (!file.exists()) {
            if (file.mkdirs()) {
                String outputFileName = classProperties.get("modelName") + fileSubfix + "." + fileExtension;

                Writer out = new OutputStreamWriter(new FileOutputStream(outputPath + "/" + outputFileName), StandardCharsets.UTF_8);
                template.process(classProperties, out);

                out.flush();
                out.close();
            }
        }
    }
}
