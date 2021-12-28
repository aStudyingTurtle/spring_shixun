package learn.shixun.shixun1.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
//@Getter
//@Setter
@Data//包含get，set，toString等
public class User implements Serializable {//Serializable使类支持序列化跟反序列化（存数据库与取数据）
    //private封装，int 基本数据类型，存在于栈上，只能为0，不能为null
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer sex;
    private Integer age;
    private Date birthday;
}
