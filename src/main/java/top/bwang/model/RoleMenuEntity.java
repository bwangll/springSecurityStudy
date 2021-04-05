package top.bwang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author bwang
 * @version 1.0
 * @Description TODO
 * @date 2021/4/5 21:30
 */
@Entity
@Table(name = "role_menu")
@Data
public class RoleMenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long mid;
    private Long rid;

}
