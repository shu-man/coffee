package edu.mum.coffee.controller.rest;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Hatake on 6/20/2017.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/create")
    public void create(Order order){
        orderService.save(order);
    }

    @GetMapping("/list")
    public List<Order> findAll(){
        return orderService.findAll();
    }

}
