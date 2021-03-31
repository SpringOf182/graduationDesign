package com.zy.service;

import com.zy.entity.Order;
import java.util.List;


/**
 * Order服务类.
 * @author Helen
 */
public interface OrderService {
    public List<Order> queryNotAcceptedOrder();
    public List<Order> querySelectedOrder(String pickUp, String delivery, String company);
    public List<Order> queryUserAcceptOrder(String recipentUID);
    public List<Order> queryUserPublishOrder(String UID);
    public Boolean insertOrder(Order order);
    public Boolean changeOrderState(Order order);
}
