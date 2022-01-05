package learn.shixun.shixun1.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuTreeVo {
    private Integer id;
    private String title;
    private List<MenuTreeVo> children;
}
