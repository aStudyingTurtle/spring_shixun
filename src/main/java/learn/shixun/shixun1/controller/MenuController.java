package learn.shixun.shixun1.controller;

import learn.shixun.shixun1.entity.Menu;
import learn.shixun.shixun1.service.MenuService;
import learn.shixun.shixun1.vo.MenuTreeVo;
import learn.shixun.shixun1.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = "/menu", method = RequestMethod.GET)
public class MenuController {
    @Autowired
    private MenuService menuService;

    //打开用户主页面
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String openPage() {
        return "menu";
    }

    //获取用户列表数据
    @ResponseBody//不返回页面，只返回json数据
    @GetMapping(value = "/list")
    public ResultVo selectMenu(String keyword, Integer page, Integer limit) {

        return menuService.selectMenu(keyword, page, limit);
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public void saveMenu(Menu menu) {
        menuService.doSave(menu);
    }

    @ResponseBody
    @PostMapping(value = "/del")
    public void delMenu(Integer id) {
        menuService.doDelete(id);
    }

    @ResponseBody
    @PostMapping(value = "/{id}")
    public Menu selectMenuById(@PathVariable("id") Integer id) {
        return menuService.selectMenuById(id);
    }

    @ResponseBody
    @GetMapping(value = "/tree")
    public List<MenuTreeVo> selectMenuTree() {
        return menuService.selectMenuTree();
    }
}
