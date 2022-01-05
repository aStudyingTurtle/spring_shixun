package learn.shixun.shixun1.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import learn.shixun.shixun1.entity.Menu;
import learn.shixun.shixun1.mapper.MenuMapper;
import learn.shixun.shixun1.vo.MenuTreeVo;
import learn.shixun.shixun1.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service //告诉Spring这是服务，以备依赖注入
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public ResultVo selectMenu(String keyword, Integer page, Integer limit) {
        ResultVo vo = new ResultVo();
        //两个参数：第几页，每页几条
        //该代码以下第一行代码会分页查询
        PageHelper.startPage(page, limit);
        List<Menu> list = menuMapper.selectMenu(keyword);
        PageInfo<Menu> pageInfo = new PageInfo<>(list);
        vo.setData(list);
        vo.setCount(pageInfo.getTotal());
        return vo;
    }

    public void doSave(Menu menu) {
        if (menu.getId() == null)//用户不存在
            menuMapper.insert(menu);
        else {
            menuMapper.updateMenu(menu);
        }
    }

    public void doDelete(@RequestParam(value = "id") Integer id) {//@RequestParam(value = "id", required = false) 非必需
        menuMapper.deleteMenu(id);
    }

    public Menu selectMenuById(Integer id) {
        return menuMapper.selectMenuById(id);
    }

    public List<MenuTreeVo> selectMenuTree() {
        return menuMapper.selectMenuTree();
//        List<MenuTreeVo> list = new ArrayList<>();
//        List<Menu> tops = selectTopMenus();
//        for (Menu m : tops) {
//            MenuTreeVo vo = new MenuTreeVo();
//            vo.setId(m.getId());
//            vo.setTitle(m.getName());
//            List<Menu> subs = menuMapper.selectByParentId(vo.getId());
//            vo.setChildren(new ArrayList<>());
//            for (Menu s : subs) {
//                MenuTreeVo subvo = new MenuTreeVo();
//                vo.setId(m.getId());
//                vo.setTitle(m.getName());
//                vo.getChildren().add(subvo);
//            }
//            list.add(vo);
//        }
//        return list;
    }

    private List<Menu> selectTopMenus() {
        return menuMapper.selectByParentId(0);
    }
}
