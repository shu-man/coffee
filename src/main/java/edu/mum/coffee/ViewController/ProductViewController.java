package edu.mum.coffee.ViewController;

import edu.mum.coffee.DTO.OrderDTO;
import edu.mum.coffee.DTO.OrderLineDTO;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Hatake on 6/21/2017.
 */
@Controller
public class ProductViewController {
    @Autowired
    private ProductService productService;

    @Autowired
    private PersonService personService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/productList")
    public String getProductList(Model model) {

        model.addAttribute("products", productService.getAllProduct());
        return "productLst";
    }

    @PostMapping("/orderNow")

    public String saveOrder(OrderLineDTO orderLineDTO, Principal principal) {
        Order order = new Order();
        order.setOrderDate(new Date());
        Person person = personService.findByEmail(principal.getName()).get(0);
        order.setPerson(person);

        Orderline orderline = new Orderline();
        orderline.setQuantity(orderLineDTO.getQuantity());
        orderline.setProduct(productService.getProduct(orderLineDTO.getProductId()));
        order.addOrderLine(orderline);

        orderService.save(order);

        return "redirect:/orderLst";

    }

    @GetMapping("/orderLst")
    public String getOrderList(Model model,Principal principal){
        model.addAttribute("orders",orderService.findByPerson(personService.findByEmail(principal.getName()).get(0)));
        return "orderList";
    }

}
