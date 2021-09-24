package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException blockException){
        return new CommonResult(4444,"客户自定义------------------1");
    }

    public static CommonResult handlerException2(BlockException blockException){
        return new CommonResult(4444,"客户自定义------------------2");
    }
}
