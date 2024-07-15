package terabu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import terabu.dto.customer.CustomerRequest;
import terabu.dto.customer.CustomerResponse;
import terabu.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public CustomerResponse save(@RequestBody CustomerRequest customerRequest) {
        return customerService.save(customerRequest);
    }

    @GetMapping("/findById")
    public CustomerResponse findById(@RequestParam("id") Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/all")
    public List<CustomerResponse> getAll() {
        return customerService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

    @PutMapping("/update")
    public CustomerResponse update(@RequestBody CustomerRequest customerRequest) {
        return customerService.update(customerRequest);
    }

}
