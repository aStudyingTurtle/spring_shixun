package learn.shixun.shixun1.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import learn.shixun.shixun1.entity.User;
import learn.shixun.shixun1.mapper.UserMapper;
import learn.shixun.shixun1.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //告诉Spring这是服务，以备依赖注入
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public ResultVo selectUser(String keyword, Integer page, Integer limit) {
        ResultVo vo = new ResultVo();
        //两个参数：第几页，每页几条
        //该代码以下第一行代码会分页查询
        PageHelper.startPage(page, limit);
        List<User> list = userMapper.selectUser(keyword);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        vo.setData(list);
        vo.setCount(pageInfo.getTotal());
        return vo;
    }
}
