package terabu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import terabu.dto.subscription.SubscriptionRequest;
import terabu.dto.subscription.SubscriptionResponse;
import terabu.service.SubscriptionService;


import java.util.List;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }


    @PostMapping("/save")
    public SubscriptionResponse save(@RequestBody SubscriptionRequest subscriptionRequest) {
        return subscriptionService.save(subscriptionRequest);
    }

    @GetMapping("/findById")
    public SubscriptionResponse findById(@RequestParam("id") Long id) {
        return subscriptionService.findById(id);

    }

    @GetMapping("/all")
    public List<SubscriptionResponse> getAll() {
        return subscriptionService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        subscriptionService.delete(id);
    }

    @PutMapping("/update")
    public SubscriptionResponse update(@RequestBody SubscriptionRequest subscriptionRequest) {
        return subscriptionService.update(subscriptionRequest);
    }
}
