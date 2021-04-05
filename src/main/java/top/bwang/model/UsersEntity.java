package top.bwang.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * @author bwang
 * @version 1.0
 * @Description TODO
 * @date 2021/4/5 21:30
 */
@Entity
@Table(name = "users")
@Data
@ToString
public class UsersEntity {
    @Id
    private long id;
    private String username;
    private String password;
}
