package ${basePackage}.web;

import ${basePackage}.domain.PageModel;
import ${basePackage}.domain.${modelName};
import ${basePackage}.service.${modelName}Service;
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
@RequestMapping(value = "/${modelName?lower_case}")
@Slf4j
public class ${modelName}Controller {

    @Autowired
    private ${modelName}Service ${modelName?lower_case}Service;

    /**
     * 列表页
     *
     * @return 对应视图
     */
    @GetMapping(value = "/page")
    public String listPage() {
        return "${modelName?lower_case}";
    }

    /**
     * 获取分页数据
     *
     * @param page  当前页数
     * @param limit 每页记录数
     * @return PageModel<${modelName}>
     */
    @PostMapping(value = "/pageData")
    public PageModel<${modelName}> pageData(int page, int limit) {
        return ${modelName?lower_case}Service.findPage(page, limit);
    }

    /**
     * 获取列表数据
     *
     * @return List<${modelName}>
     */
    @GetMapping
    @ResponseBody
    public List<${modelName}> listData() {
        return ${modelName?lower_case}Service.findList();
    }

    /**
     * 添加
     *
     * @param ${modelName} entity
     * @return ResponseEntity<${modelName}>
     */
    @PostMapping
    public ResponseEntity<${modelName}> add(@RequestBody ${modelName} ${modelName?lower_case}) {
        try {
            ${modelName?lower_case} = ${modelName?lower_case}Service.saveOrUpdate(${modelName?lower_case});
        } catch (Exception e) {
            log.error("保存${modelName}失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(${modelName?lower_case}, HttpStatus.OK);
    }

    /**
     * 修改
     *
     * @param ${modelName} entity
     * @return ResponseEntity<${modelName}>
     */
    @PutMapping
    public ResponseEntity<${modelName}> edit(@RequestBody ${modelName} ${modelName?lower_case}) {
        try {
            ${modelName?lower_case} = ${modelName?lower_case}Service.saveOrUpdate(${modelName?lower_case});
        } catch (Exception e) {
            log.error("修改${modelName}失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(${modelName?lower_case}, HttpStatus.OK);
    }

    /**
     * 删除
     *
     * @param id entity id
     * @return ResponseEntity<${modelName}>
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<${modelName}> del(@PathVariable(value = "id") Integer id) {
        try {
            ${modelName} ${modelName?lower_case} = ${modelName?lower_case}Service.findById(id);
            if (${modelName?lower_case} != null) {
                ${modelName?lower_case}Service.del(${modelName?lower_case});
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
