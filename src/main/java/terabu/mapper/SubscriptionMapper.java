package terabu.mapper;

import org.mapstruct.Mapper;
import terabu.dto.subscription.SubscriptionRequest;
import terabu.dto.subscription.SubscriptionResponse;
import terabu.entity.Subscription;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    public Subscription toEntity(SubscriptionRequest subscriptionRequest);
    public SubscriptionResponse toResponse(Subscription subscription);
}
