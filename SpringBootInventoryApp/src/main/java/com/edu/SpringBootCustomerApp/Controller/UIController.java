package com.edu.SpringBootCustomerApp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Entity.Order;
import com.edu.SpringBootCustomerApp.Entity.Product;
import com.edu.SpringBootCustomerApp.Entity.Stock;
import com.edu.SpringBootCustomerApp.Entity.Supplier;
import com.edu.SpringBootCustomerApp.Service.CustomerService;
import com.edu.SpringBootCustomerApp.Service.OrderService;
import com.edu.SpringBootCustomerApp.Service.ProductService;
import com.edu.SpringBootCustomerApp.Service.StockService;
import com.edu.SpringBootCustomerApp.Service.SupplierService;
import com.edu.SpringBootCustomerApp.ServiceImplementation.CustomerServiceImplementation;

@Controller
public class UIController {
	private CustomerService customerService;
	private ProductService productService;
	private OrderService orderService;
	private StockService stockService;
	private SupplierService supplierService;
	
	@Autowired	
	public UIController(CustomerService customerService,ProductService productService,OrderService orderService,
			StockService stockService,SupplierService supplierService) {
		super();
		this.customerService=customerService;
		this.productService=productService;
		this.orderService=orderService;
		this.stockService=stockService;
		this.supplierService=supplierService;
	}
	public String currentUser(){
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userEmail;
		if(principal instanceof UserDetails)
		{
			userEmail=((UserDetails)principal).getUsername();
		}else {
			userEmail=principal.toString();
		}
		return userEmail;
	}
	
@GetMapping("/")
	
	String index() {
		return "index";/// index.html
	}
@GetMapping("/login")

public String login() {
	return "login";
}
@GetMapping("/logout")
public String logout(HttpServletRequest request,HttpServletResponse response) {
	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	if(auth!=null) {
		new SecurityContextLogoutHandler().logout(request,response,auth);
		}
	return "redirect:/";
}
@GetMapping("/customer/registration")
public String custRegistrationForm(Model model) {
	Customer customer = new Customer();
	model.addAttribute("customer", customer);
    return "add-customer";
}

@PostMapping("/customer/saveCustomer")
public String saveCustomer(@Valid  Customer customer, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    customerService.saveCustomer(customer);
	List<Customer> customers=  customerService.getAllCustomer();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
   return "redirect:/index";
	
}


@GetMapping("/admin/getCustomers")
public String getAllCustomer(Model model) {
	
	List<Customer> customers =  customerService.getAllCustomer();
	
	model.addAttribute("customers", customers);
	
    return "list-customer";
    }
@RequestMapping(value="/customers/editCust/{id}",method= {RequestMethod.GET,RequestMethod.PUT})
public String updateCustomer(@PathVariable("id")long id,@ModelAttribute Customer customer) {
	customerService.updateCustomer(customer,id);///customers/editCust/{id}
	return "list-customer";
}
@RequestMapping(value="/customers/deleteCust/{id}",method= {RequestMethod.GET,RequestMethod.DELETE})
public String deleteCustomer(@PathVariable("id")long id,@ModelAttribute Customer customer) {
	customerService.deleteCustomer(id);
	return "list-customer";
}
@GetMapping("/admin/productRegister")
public String proRegistrationForm(Model model) {
	Product product = new Product();
	model.addAttribute("product", product);
    return "add-product";
}
@PostMapping("/admin/saveProduct")
public String saveProduct(@Valid  Product product, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    productService.saveProduct(product);
	List<Product> products=  productService.getAllProduct();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/index";
    
}
@GetMapping("/customer/getProducts")
public String getAllProduct(Model model) {
	
	List<Product> products =  productService.getAllProduct();
	
	model.addAttribute("products", products);
	
    return "list-product";
    }
@RequestMapping(value="/products/editPro/{id}",method= {RequestMethod.GET,RequestMethod.PUT})
public String updateProduct(@PathVariable("id")Long id,@ModelAttribute Product product) {
	productService.updateProduct(product,id);
	return "list-product";
}
@RequestMapping(value="/products/deletePro/{id}",method= {RequestMethod.GET,RequestMethod.DELETE})
public String deleteProduct(@PathVariable("id")long id,@ModelAttribute Product product) {
	productService.deleteProduct(id);
	return "list-product";
}
@GetMapping("/admin/orderRegister")
public String ordRegistrationForm(Model model) {
	Order order  = new Order();
	model.addAttribute("order", order);
    return "add-order";
}
@PostMapping("/admin/saveOrder")
public String saveOrder(@Valid  Order order, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    orderService.saveOrder(order);
	List<Order> orders=  orderService.getAllOrder();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/index";
    
}
@GetMapping("/customer/getOrders")
public String getAllOrder(Model model) {
	
	List<Order> orders =  orderService.getAllOrder();
	
	model.addAttribute("orders", orders);
	
    return "list-order";
    }
@GetMapping("/admin/stockRegister")
public String stkRegistrationForm(Model model) {
	Stock stock  = new Stock();
	model.addAttribute("stock", stock);
    return "add-stock";
}
@PostMapping("/admin/saveStock")
public String saveStock(@Valid Stock stock , Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    stockService.saveStock(stock);
	List<Stock> stocks=  stockService.getAllStock();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/index";
    
}
@GetMapping("/customer/getStocks")
public String getAllStock(Model model) {
	
	List<Stock> stocks =  stockService.getAllStock();
	
	model.addAttribute("stocks", stocks);
	
    return "list-stock";
    }
@GetMapping("/admin/supplierRegister")
public String supRegistrationForm(Model model) {
	Supplier supplier  = new Supplier();
	model.addAttribute("supplier", supplier);
    return "add-supplier";
}
@PostMapping("/admin/saveSupplier")
public String saveSupplier(@Valid Supplier supplier , Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    supplierService.saveSupplier(supplier);
	List<Supplier> suppliers=  supplierService.getAllSupplier();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/index";
    
}
@GetMapping("/customer/getSuppliers")
public String getAllSupplier(Model model) {
	
	List<Supplier> suppliers =  supplierService.getAllSupplier();
	
	model.addAttribute("suppliers", suppliers);
	
    return "list-supplier";
    }
}


