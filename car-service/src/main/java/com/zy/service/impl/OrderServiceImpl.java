package com.zy.service.impl;

import lombok.extern.slf4j.Slf4j;
import mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zy.service.OrderService;
import com.zy.entity.Order;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * Order业务服务实现类.
 * @author Helen
 */
@Service("orderService")
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> queryNotAcceptedOrder(){
        Example example = new Example(Order.class);
        //排序使用的是列名，数据库里面的列名
        example.orderBy("latestTime").asc();
        example.createCriteria()
                .andEqualTo("state", 0);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> querySelectedOrder(String pickUp, String delivery, String company){
        Example example = new Example(Order.class);
        //排序使用的是列名，数据库里面的列名
        example.orderBy("latestTime").asc();
        example.createCriteria()
                .andEqualTo("state", 0)
                .andEqualTo("pickUp",pickUp)
                .andEqualTo("delivery",delivery)
                .andEqualTo("company",company);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> queryUserAcceptOrder(String recipentUID){
        Example example = new Example(Order.class);
        //排序使用的是列名，数据库里面的列名
        example.orderBy("state").asc();
        example.createCriteria()
                .andEqualTo("recipentUID", recipentUID);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> queryUserPublishOrder(String UID){
        Example example = new Example(Order.class);
        //排序使用的是列名，数据库里面的列名
        example.orderBy("state").asc();
        example.createCriteria()
                .andEqualTo("UID", UID);
        return orderMapper.selectByExample(example);
    }

    @Override
    public Boolean insertOrder(Order order) {
        try{
            orderMapper.insert(order);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean changeOrderState(Order order){
        if(orderMapper.updateByPrimaryKeySelective(order)!= 0){
            return true;
        }
        return false;
    }

}
