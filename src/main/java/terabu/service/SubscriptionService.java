package terabu.service;

import terabu.dto.subscription.SubscriptionRequest;
import terabu.dto.subscription.SubscriptionResponse;

import java.util.List;

public interface SubscriptionService {
    public SubscriptionResponse save(SubscriptionRequest subscriptionRequest);
    public SubscriptionResponse findById(Long id);
    public List<SubscriptionResponse> getAll();
    public void delete(Long id);
    public SubscriptionResponse update(SubscriptionRequest subscriptionRequest);

}
