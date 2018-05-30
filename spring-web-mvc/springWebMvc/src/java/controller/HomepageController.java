/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import dao.ProviderDao;
import dao.UserDao;
import entity.Product;
import entity.Provider;
import entity.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Rio.Rai
 */
@Controller
@RequestMapping(value = "/home")
public class HomepageController {
    
    UserDao userDao = new UserDao();//UserService
    ProviderDao providerDao = new ProviderDao();//ProviderService
    ProductDao productDao = new ProductDao();//ProdcutService
    
    //tra ve trang index
    @RequestMapping(value = "/index")
    public String index() {
    
        return "jsp/index";
    }
    
    //tra ve trang login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
    
        return "jsp/login";
    }
    
    //logout quay ve trang login
    //huy session userName
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
    
        session.removeAttribute("userName");
        return "redirect:login";
    }
    
    //tra ve trang manager
    @RequestMapping(value = "/manager")
    public String manager() {
    
        return "jsp/manager";
    }
    
    //gui email password tu trang jsp
    //neu tim thay user tra ve trang manager
    //neu khong tim thay quay lai trang login voi
    //thong bao "message erro"
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("userForm") User u, ModelMap mm) {
    
        User user = userDao.login(u.getUserEmail(), u.getPassword());
        
        if(user != null) {
        
            HttpSession session = request.getSession();
            session.setAttribute("userName", user.getUserName());
            return "jsp/manager";
        }else {
        
            mm.put("msg", "Incorrect email or password!");
            return "jsp/login";
        }
    }
    
    //tra ve trang provider
    //lay toan bo danh sach nha cung cap
    @RequestMapping(value = "/providers")
    public String categories(ModelMap mm) {
    
        mm.put("providerList", providerDao.getAllProvider());
        return "jsp/provider";
    }
    
    //tra ve trang them nha cung cap
    @RequestMapping(value = "/add-provider", method = RequestMethod.GET)
    public String addProvider() {
    
        return "jsp/add-provider";
    }
    
    //them moi 1 nha cung cap moi
    //neu ham providerDao.insertNewProvider(provider) == true
    //xuat ra thong bao success!
    //neu ham providerDao.insertNewProvider(provider) == false
    //xuat ra thong bao Provider ID already Exists!
    @RequestMapping(value = "/add-provider", method = RequestMethod.POST)
    public String addProvider(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("providerForm")Provider provider, ModelMap mm) {
    
        if(providerDao.insertNewProvider(provider)) {
            mm.put("scc", "Success!");
            return "jsp/add-provider";
        }
        else{
            mm.put("err", "Provider ID already Exists!");
            return "jsp/add-provider";
        }
    }
    
    //tra ve trang product
    @RequestMapping(value ="/products", method = RequestMethod.GET)
    public String product(ModelMap mm) {
    
        mm.put("productList", productDao.getAllProduct());
        return "jsp/product";
    }
    
    //tra ve trang them san phan
    //lay danh sach nha cung cap load len selection
    @RequestMapping(value = "/add-product", method = RequestMethod.GET)
    public String addProduct(ModelMap mm) {
    
        mm.put("providerList", providerDao.getAllProvider());
        return "jsp/add-product";
    }
    
    //lay du lieu tu productForm them moi 1 san pham
    //xuat thong bao thanh cong
    //xuat thong bao loi
    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String addProduct(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("productForm")Product product, ModelMap mm) {
    
        if(productDao.insertProduct(product)){
        
            mm.put("scc", "Added new product!");
        }
        else
            mm.put("err", "Fail add new product, please checked info!");
        return "jsp/add-product";
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String getDetailProduct(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("productId") String productId, ModelMap mm) {
    
        ArrayList<Product> productDetail = productDao.getProductBy(productId);
        if(productDao.getProductBy(productId)!=null) {          
            mm.put("productDetail", productDetail);
            return "jsp/detail";
        }
        else {
            return "jsp/not-thing";
        }
    }
}
