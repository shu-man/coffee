package edu.mum.coffee.controller.rest;

import edu.mum.coffee.DTO.OrderDTO;
import edu.mum.coffee.DTO.OrderLineDTO;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hatake on 6/20/2017.
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    private OrderService orderService;
    private PersonService personService;
    private ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, PersonService personService, ProductService productService) {
        this.orderService = orderService;
        this.personService = personService;
        this.productService = productService;

    }

    @PostMapping(path = "/create", consumes = "application/json")
    public void create(@RequestBody OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDate(orderDTO.getOrderDate());
        Person person = personService.findById(orderDTO.getPersonId());
        order.setPerson(person);
        if (orderDTO.getOrderLinesDTO() != null) {
            for (OrderLineDTO orderLineDTO : orderDTO.getOrderLinesDTO()) {
                Orderline orderline = new Orderline();
                orderline.setQuantity(orderLineDTO.getQuantity());
                orderline.setProduct(productService.getProduct(orderLineDTO.getProductId()));

                order.addOrderLine(orderline);
            }
        }
        orderService.save(order);
    }

    @GetMapping("/list")

    public List<Order> findAll() {
        return orderService.findAll();
    }

}
