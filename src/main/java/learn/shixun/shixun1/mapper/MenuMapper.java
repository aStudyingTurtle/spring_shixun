package learn.shixun.shixun1.mapper;


import learn.shixun.shixun1.entity.Menu;
import learn.shixun.shixun1.vo.MenuTreeVo;

import java.util.List;

//mapper只定义接口，mybatis使用
//既需要分页，又需要查总数
//或者使用插件page helper
public interface MenuMapper {
    public List<Menu> selectMenu(String keyword);

    public int insert(Menu menu);

    public int deleteMenu(Integer id);

    public Menu selectMenuById(Integer id);

    public int updateMenu(Menu menu);

//    public List<Menu> selectTopMenus();

    public List<Menu> selectByParentId(Integer id);

    public List<MenuTreeVo> selectMenuTree();
}
