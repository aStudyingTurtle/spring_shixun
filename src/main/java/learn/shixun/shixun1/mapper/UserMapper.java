package learn.shixun.shixun1.mapper;

import learn.shixun.shixun1.entity.User;

import java.util.List;

//mapper只定义接口，mybatis使用
//既需要分页，又需要查总数
//或者使用插件page helper
public interface UserMapper {
    public List<User> selectUser(String keyword);

    public int insert(User user);

    public int deleteUser(Integer uid);

    public User selectUserById(Integer id);

    public int updateUser(User user);
}
