package learn.shixun.shixun1.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import learn.shixun.shixun1.entity.Role;
import learn.shixun.shixun1.mapper.RoleMapper;
import learn.shixun.shixun1.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service //告诉Spring这是服务，以备依赖注入
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public ResultVo selectRole(String keyword, Integer page, Integer limit) {
        ResultVo vo = new ResultVo();
        //两个参数：第几页，每页几条
        //该代码以下第一行代码会分页查询
        PageHelper.startPage(page, limit);
        List<Role> list = roleMapper.selectRole(keyword);
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        vo.setData(list);
        vo.setCount(pageInfo.getTotal());
        return vo;
    }

    public void doSave(Role role) {
        if (role.getId() == null)//用户不存在
            roleMapper.insert(role);
        else {
            roleMapper.updateRole(role);
        }
    }

    public void doDelete(@RequestParam(value = "id") Integer id) {//@RequestParam(value = "id", required = false) 非必需
        roleMapper.deleteRole(id);
    }

    public Role selectRoleById(Integer id) {
        return roleMapper.selectRoleById(id);
    }
}
