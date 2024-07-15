package terabu.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import terabu.dto.subscription.SubscriptionRequest;
import terabu.dto.subscription.SubscriptionResponse;
import terabu.entity.Customer;
import terabu.entity.Subscription;
import terabu.mapper.SubscriptionMapper;
import terabu.repository.CustomerRepository;
import terabu.repository.SubscriptionRepository;
import terabu.service.SubscriptionService;

import java.util.List;

@Transactional
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    public final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, SubscriptionMapper subscriptionMapper, CustomerRepository customerRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionMapper = subscriptionMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public SubscriptionResponse save(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionMapper.toEntity(subscriptionRequest);
        Customer customer = customerRepository.findById(subscriptionRequest.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        subscription.setCustomer(customer);
        SubscriptionResponse response = subscriptionMapper.toResponse(subscriptionRepository.save(subscription));
        response.setCustomerId(subscriptionRequest.getCustomerId());
        return response;
    }

    @Override
    public SubscriptionResponse findById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found"));
        SubscriptionResponse response = subscriptionMapper.toResponse(subscription);
        response.setCustomerId(subscription.getCustomer().getId());
        return response;

    }

    @Override
    public List<SubscriptionResponse> getAll() {
        return subscriptionRepository.findAll().stream().map(subscription -> {
            SubscriptionResponse response = subscriptionMapper.toResponse(subscription);
            response.setCustomerId(subscription.getCustomer().getId());
            return response;
        }).toList();
    }

    @Override
    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public SubscriptionResponse update(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionRepository.findById(subscriptionRequest.getId()).orElseThrow(() -> new RuntimeException("Subscription not found"));
        Customer customer = customerRepository.findById(subscriptionRequest.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        subscription.setCustomer(customer);
        subscription.setStartDate(subscriptionRequest.getStartDate());
        subscription.setEndDate(subscriptionRequest.getEndDate());
        subscription.setPrice(subscription.getPrice());
        subscription.setName(subscriptionRequest.getName());
        SubscriptionResponse response = subscriptionMapper.toResponse(subscriptionRepository.save(subscription));
        response.setCustomerId(subscriptionRequest.getCustomerId());
        return response;
    }
}
