package learn.shixun.shixun1.vo;

import lombok.Data;

import java.util.List;

//layui分页结果展示对象
@Data
public class ResultVo {
    private Integer code = 0;
    private String msg;
    private List<?> data;//不知道啥类型，返回啥都可以
    //或者private List<Object> data;
    private long count;
}
