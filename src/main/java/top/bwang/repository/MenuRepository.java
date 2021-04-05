package top.bwang.repository;

import org.springframework.data.repository.CrudRepository;

import top.bwang.model.MenuEntity;

/**
 * @author bwang
 * @version 1.0
 * @Description TODO
 * @date 2021/4/5 21:43
 */
public interface MenuRepository extends CrudRepository<MenuEntity, Long> {
}
