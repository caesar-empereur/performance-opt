package com.controller;

import com.model.Order;
import com.repository.OrderRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/1/29.
 */
@Api(value = "订单获取接口")
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    private OrderRepository orderRepository;

    @ApiOperation(value = "get")
    @GetMapping("/get")
    public List<Order> message(){
        log.info("接收到请求");

        return orderRepository.findAll();
    }
}
