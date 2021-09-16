package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;//响应码
    private String message;//响应信息
    private T   data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}