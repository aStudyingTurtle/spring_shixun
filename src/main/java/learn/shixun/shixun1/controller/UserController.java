package learn.shixun.shixun1.controller;

import learn.shixun.shixun1.entity.User;
import learn.shixun.shixun1.service.UserService;
import learn.shixun.shixun1.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//用户控制器
@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
    //IOC 控制反转
    //传统方式UserService service = new UserService();
    //DI 依赖注入,由Spring自动注入
    @Autowired
    private UserService userService;

    //打开用户主页面
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String openPage() {
        return "user";
    }

    //获取用户列表数据
    @ResponseBody//不返回页面，只返回json数据
    @GetMapping(value = "/list")
    public ResultVo selectUser(String keyword, Integer page, Integer limit) {

        return userService.selectUser(keyword, page, limit);
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public void saveUser(User user) {
        userService.doSave(user);
    }

    @ResponseBody
    @PostMapping(value = "/del")
    public void delUser(Integer id) {
        userService.doDelete(id);
    }

    @ResponseBody
    @PostMapping(value = "/{id}")
    public User selectUserById(@PathVariable("id") Integer id) {
        return userService.selectUserById(id);
    }
}
