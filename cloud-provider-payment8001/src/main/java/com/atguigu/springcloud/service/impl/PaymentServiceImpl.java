package com.atguigu.springcloud.service.impl;


import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    //创建一个Payment
    public int create(Payment payment){
      return paymentDao.create(payment);
    }

    //读取一个Payment
    public Payment getPaymentById(@Param("id") Long id){
       return paymentDao.getPaymentById(id);
    }
}
