package terabu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import terabu.entity.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}