package com.example.eureka.ribbon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class OrderController {

    @RequestMapping(value = "/order", method = POST, produces = "application/json")
    @ResponseBody
    public Order orderMovie(@RequestBody NewOrderDetails newOrderDetails) {
        return new Order(UUID.randomUUID().toString());
    }
}