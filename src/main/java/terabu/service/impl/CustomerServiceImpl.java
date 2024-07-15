package terabu.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import terabu.dto.customer.CustomerRequest;
import terabu.dto.customer.CustomerResponse;
import terabu.entity.Customer;
import terabu.mapper.CustomerMapper;
import terabu.repository.CustomerRepository;
import terabu.service.CustomerService;

import java.util.List;
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {
        Customer customer = customerMapper.toEntity(customerRequest);
        return customerMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.findAll().stream().map(customerMapper::toResponse).toList();
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest) {
        Customer customer = customerRepository.findByEmail(customerRequest.getEmail()).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customerRepository.save(customer);
        return customerMapper.toResponse(customer);
    }
}
