/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Rio.Rai
 */

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    
    ProductDao productDao = new ProductDao();//productService
    
    //tra ve trang chi tiet san pham
    //@RequestMapping(value = "/detail")
    //public String getDetailProduct() {
    
  //      return "jsp/detail";
   // }
    
    
    @RequestMapping(value = "/detail")
    public String getDetailProduct(@RequestParam String productId, ModelMap mm) {
    
        if(productDao.getProductBy(productId)!=null) {          
            mm.put("productList", productDao.getProductBy(productId));
            return "jsp/detail";
        }
        else {
            return "jsp/not-thing";
        }
    }
}
