package org.example.controllers;

import org.example.models.Customer;
import org.example.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    @Resource
    CustomerRepository customerRepository;

    private List<String> tasks = Arrays.asList("张三", "李四", "王五");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

    @GetMapping("/element")
    public String mainWithParam( Model model) {

        return "elementui"; //view
    }

    @GetMapping("/customer")
    public String customerHome( Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customerview"; //view
    }

    @GetMapping("/custajax")
    public String customerAjaxHome( Model model) {
        return "customerajax"; //view
    }

    @GetMapping("/ajax")
    public String AjaxHome( Model model) {
        return "Ajax"; //view
    }

    @GetMapping("/form")
    public String FormHome( Model model) {
        return "Form"; //view
    }

    @GetMapping("/example")
    public String exampleHome( Model model) {
        return "blank"; //view
    }

}