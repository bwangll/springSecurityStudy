package top.bwang.repository;

import org.springframework.data.repository.CrudRepository;

import top.bwang.model.RoleEntity;

/**
 * @author bwang
 */
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
