package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PaymentService {
    //创建一个Payment
    public int create(Payment payment);

    //读取一个Payment
    public Payment getPaymentById(@Param("id") Long id);
}
