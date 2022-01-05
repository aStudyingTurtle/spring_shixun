package learn.shixun.shixun1.mapper;

import learn.shixun.shixun1.entity.Role;

import java.util.List;

//mapper只定义接口，mybatis使用
//既需要分页，又需要查总数
//或者使用插件page helper
public interface RoleMapper {
    public List<Role> selectRole(String keyword);

    public int insert(Role role);

    public int deleteRole(Integer id);

    public Role selectRoleById(Integer id);

    public int updateRole(Role role);
}
