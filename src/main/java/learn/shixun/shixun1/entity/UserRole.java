package learn.shixun.shixun1.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserRole implements Serializable {//Serializable使类支持序列化跟反序列化（存数据库与取数据）
    //    序列化ID的，不加会有警告
    private static final long serialVersionUID = 1L;
    //private封装，int 基本数据类型，存在于栈上，只能为0，不能为null
    private Integer id;
    private Integer role_id;
    private Integer user_id;
}
