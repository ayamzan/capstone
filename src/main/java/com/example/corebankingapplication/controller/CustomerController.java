package com.example.corebankingapplication.controller;

<<<<<<< HEAD
=======
import java.security.Principal;
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.corebankingapplication.model.Customer;
import com.example.corebankingapplication.repo.CustomerRepository;

@Controller
<<<<<<< HEAD
@RequestMapping("/customers")
public class CustomerController {

    private boolean isEdit = false;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/")
    public String showCustomers(Model model) {
        List<Customer> customersList = customerRepository.findAll();
        model.addAttribute("customersList", customersList);
        return "showcustomers";
    }

    @RequestMapping("/new")
    public String addCustomer(Model model) {
        isEdit = false;
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("customer", new Customer());
        return "addcust";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") Long id, Model model) {
        isEdit = true;
        Customer customer = customerRepository.findById(id).orElseThrow();
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("customer", customer);
        return "addcust";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id, Model model) {
        customerRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/save")
    public String saveCustomer(Customer customer) {
        System.out.println(customer);
        customerRepository.save(customer);
        return "redirect:/customers/";
    }

=======
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/list")
    public String showCust(Model model, Principal principal) {
        List<Customer> custList = customerRepository.findAll();
        model.addAttribute("customers", custList);
        return "viewcustomers";
    }
    
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
}
