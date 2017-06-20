package edu.mum.coffee.controller.rest;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Hatake on 6/18/2017.
 */
@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("/productList")
    public List<Product> getAllProducts() {

        return productService.getAllProduct();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {

        productService.save(product);

    }

    @RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
    public Response updateProduct(@RequestBody Product product, @PathVariable int id){
        try {
          product.setId(id);
            productService.save(product);
            return Response.ok().entity("Success").build();
        }
        catch(Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }

    }


}

