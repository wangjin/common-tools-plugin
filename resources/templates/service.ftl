package ${basePackage}.service;

import ${basePackage}.domain.PageModel;
import ${basePackage}.domain.${modelName};
import ${basePackage}.domain.${modelName}Repository;
import ${basePackage}.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author WangJin
 * @version 1.0
 */
@Service
public class ${modelName}Service {

    @Autowired
    private ${modelName}Repository ${modelName?lower_case}Repository;


    public PageModel<${modelName}> findPage(int page, int limit) {
        return PageUtil.parsePage(${modelName?lower_case}Repository.findAll(PageRequest.of(page - 1, limit)));
    }

    public List<${modelName}> findList() {
        return ${modelName?lower_case}Repository.findAll();
    }

    public ${modelName} saveOrUpdate(${modelName} ${modelName?lower_case}) {
        return ${modelName?lower_case}Repository.save(${modelName?lower_case});
    }

    public ${modelName} findById(Integer id) {
        Optional<${modelName}> optional = ${modelName?lower_case}Repository.findById(id);
        return optional.orElse(null);
    }

    public void del(${modelName} ${modelName?lower_case}) {
        ${modelName?lower_case}Repository.delete(${modelName?lower_case});
    }
}
