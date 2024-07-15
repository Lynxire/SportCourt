package terabu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import terabu.entity.Subscription;


public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
