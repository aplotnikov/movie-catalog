package com.example.eureka.ribbon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static AtomicInteger counter = new AtomicInteger();

    @RequestMapping(value = "/orders", method = POST, produces = "application/json")
    public ResponseEntity<Order> orderMovie(@RequestBody NewOrderDetails newOrderDetails) {
        LOG.info("my message " + newOrderDetails.getTitle());

        if (counter.incrementAndGet() % 2 == 0) {
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new Order("500"));
        }

        return ResponseEntity.ok(new Order(UUID.randomUUID().toString()));
    }
}
