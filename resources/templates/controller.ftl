package ${packageInfo.basePackage}.${packageInfo.controllerPackage};

import ${packageInfo.basePackage}.${packageInfo.entityPackage}.PageModel;
import ${packageInfo.basePackage}.${packageInfo.entityPackage}.${modelName};
import ${packageInfo.basePackage}.${packageInfo.servicePackage}.${modelName}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WangJin
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/${lowerFirstLetter(modelName)}")
@Slf4j
public class ${modelName}Controller {

    @Autowired
    private ${modelName}Service ${lowerFirstLetter(modelName)}Service;

    /**
     * 列表页
     *
     * @return 对应视图
     */
    @GetMapping(value = "/page")
    public String listPage() {
        return "${lowerFirstLetter(modelName)}";
    }

    /**
     * 获取分页数据
     *
     * @param page  当前页数
     * @param limit 每页记录数
     * @return PageModel<${modelName}>
     */
    @GetMapping(value = "/pageData")
    @ResponseBody
    public PageModel<${modelName}> pageData(int page, int limit) {
        return ${lowerFirstLetter(modelName)}Service.findPage(page, limit);
    }

    /**
     * 获取列表数据
     *
     * @return List<${modelName}>
     */
    @GetMapping
    @ResponseBody
    public List<${modelName}> listData() {
        return ${lowerFirstLetter(modelName)}Service.findList();
    }

    /**
     * 添加
     *
     * @param ${lowerFirstLetter(modelName)} entity
     * @return ResponseEntity<${modelName}>
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<${modelName}> add(@RequestBody ${modelName} ${lowerFirstLetter(modelName)}) {
        try {
            ${lowerFirstLetter(modelName)} = ${lowerFirstLetter(modelName)}Service.saveOrUpdate(${lowerFirstLetter(modelName)});
        } catch (Exception e) {
            log.error("保存${modelName}失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(${lowerFirstLetter(modelName)}, HttpStatus.OK);
    }

    /**
     * 修改
     *
     * @param ${lowerFirstLetter(modelName)} entity
     * @return ResponseEntity<${modelName}>
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<${modelName}> edit(@RequestBody ${modelName} ${lowerFirstLetter(modelName)}) {
        try {
            ${lowerFirstLetter(modelName)} = ${lowerFirstLetter(modelName)}Service.saveOrUpdate(${lowerFirstLetter(modelName)});
        } catch (Exception e) {
            log.error("修改${modelName}失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(${lowerFirstLetter(modelName)}, HttpStatus.OK);
    }

    /**
     * 删除
     *
     * @param id entity id
     * @return ResponseEntity<${modelName}>
     */
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<${modelName}> del(@PathVariable(value = "id") Integer id) {
        try {
            ${modelName} ${lowerFirstLetter(modelName)} = ${lowerFirstLetter(modelName)}Service.findById(id);
            if (${lowerFirstLetter(modelName)} != null) {
                ${lowerFirstLetter(modelName)}Service.del(${lowerFirstLetter(modelName)});
            } else {
                log.warn("id=[{}]的${modelName}不存在", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("删除${modelName}失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
