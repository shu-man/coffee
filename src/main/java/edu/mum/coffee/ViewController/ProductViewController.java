package edu.mum.coffee.ViewController;

import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Hatake on 6/21/2017.
 */
@Controller
public class ProductViewController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productList")
    public String getProductList(Model model) {

        model.addAttribute("products", productService.getAllProduct());
        return "productLst";
    }
}
