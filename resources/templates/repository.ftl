package ${packageInfo.basePackage}.${packageInfo.repositoryPackage};

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author WangJin
 * @version 1.0
 */
@Repository
public interface ${modelName}Repository extends JpaRepository<${modelName}, Integer> {

}