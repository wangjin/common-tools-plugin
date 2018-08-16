package com.github.wangjin252.commontools.util;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

public class ModelNameFreemakerMethodEx implements TemplateMethodModelEx {
    @Override
    public Object exec(List list) throws TemplateModelException {

        String modelName = list.get(0).toString();
        return StringUtil.firstLetterLower(modelName);
    }
}
