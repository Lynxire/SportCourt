package terabu.mapper;

import org.mapstruct.Mapper;
import terabu.dto.customer.CustomerRequest;
import terabu.dto.customer.CustomerResponse;
import terabu.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    public Customer toEntity(CustomerRequest customerRequest);
    public CustomerResponse toResponse(Customer customer);
}
