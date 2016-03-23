package com.example.eureka.ribbon;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class OrderController {
    private static AtomicInteger counter = new AtomicInteger();

    @RequestMapping(value = "/orders", method = POST, produces = "application/json")
    public Order orderMovie(@RequestBody NewOrderDetails newOrderDetails) {
        if (counter.incrementAndGet() % 2 == 0) {
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
            return new Order("500");
        }

        return new Order(UUID.randomUUID().toString());
    }
}
