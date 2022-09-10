package com.mp.cg.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack(){
        return Mono.just("Order service is taking too long time or down. Please try later");
    }

    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentServiceFallBack(){
        return Mono.just("Payment service ia taking too long time or down. Please try later");
    }
}
