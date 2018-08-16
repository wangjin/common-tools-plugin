package ${packageInfo.basePackage}.${packageInfo.servicePackage};

import ${packageInfo.basePackage}.${packageInfo.entityPackage}.PageModel;
import ${packageInfo.basePackage}.${packageInfo.entityPackage}.${modelName};
import ${packageInfo.basePackage}.${packageInfo.repositoryPackage}.${modelName}Repository;
import ${packageInfo.basePackage}.util.PageUtil;
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
    private ${modelName}Repository ${lowerFirstLetter(modelName)}Repository;


    public PageModel<${modelName}> findPage(int page, int limit) {
        return PageUtil.parsePage(${lowerFirstLetter(modelName)}Repository.findAll(PageRequest.of(page - 1, limit)));
    }

    public List<${modelName}> findList() {
        return ${lowerFirstLetter(modelName)}Repository.findAll();
    }

    public ${modelName} saveOrUpdate(${modelName} ${lowerFirstLetter(modelName)}) {
        return ${lowerFirstLetter(modelName)}Repository.save(${lowerFirstLetter(modelName)});
    }

    public ${modelName} findById(Integer id) {
        Optional<${modelName}> optional = ${lowerFirstLetter(modelName)}Repository.findById(id);
        return optional.orElse(null);
    }

    public void del(${modelName} ${lowerFirstLetter(modelName)}) {
        ${lowerFirstLetter(modelName)}Repository.delete(${lowerFirstLetter(modelName)});
    }
}
