package com.example.eureka.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class OrderController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/orders", method = POST, produces = "application/json")
    public Order orderMovie(@RequestBody NewOrderDetails newOrderDetails) {
        return new Order(UUID.randomUUID().toString());
    }
}
