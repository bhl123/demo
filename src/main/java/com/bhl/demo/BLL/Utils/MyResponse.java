package com.bhl.demo.BLL.Utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MyResponse<T> implements Serializable {
    private static final long serialVersionUID = 2117908111110957893L;
    // 返回code
    private Integer code;
    // 返回message
    private String codeMsg;
    // 返回数据
    private T data;
    //
    private Map<String,Object> map;

}

