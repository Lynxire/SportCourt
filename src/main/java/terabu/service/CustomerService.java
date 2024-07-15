package terabu.service;

import terabu.dto.customer.CustomerRequest;
import terabu.dto.customer.CustomerResponse;

import java.util.List;


public interface CustomerService {
    public CustomerResponse save(CustomerRequest customerRequest);
    public CustomerResponse findById(Long id);
    public List<CustomerResponse> getAll();
    public void deleteById(Long id);
    public CustomerResponse update(CustomerRequest customerRequest);
}
