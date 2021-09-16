package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    //创建一个Payment
    public int create(Payment payment);

    //读取一个Payment
    public Payment getPaymentById(@Param("id") Long id);
}
