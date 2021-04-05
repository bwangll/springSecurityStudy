package top.bwang.repository;

import org.springframework.data.repository.CrudRepository;

import top.bwang.model.UsersEntity;

/**
 * @author bwang
 * @version 1.0
 * @Description TODO
 * @date 2021/4/5 21:39
 */
public interface UserRepository extends CrudRepository<UsersEntity, Long> {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    UsersEntity findByUsername(String username);
}
