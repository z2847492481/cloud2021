package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{

    //声明一个原子属性
    private AtomicInteger atomicInteger=new AtomicInteger(0);

   /* 获取将要调用的服务在服务列表的下标
       CAS+自旋锁
       假设此时是第一次访问，则current=0，next如果不超过最大值就会+1
       next操作完之后，就会把current与预期的current对比，如果相等，则把next的值赋给current；
       不相等则再执行上述步骤
    */
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*********第几次访问："+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
