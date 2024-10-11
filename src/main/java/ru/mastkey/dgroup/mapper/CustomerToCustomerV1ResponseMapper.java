package ru.mastkey.dgroup.mapper;

import jakarta.annotation.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;
import ru.mastkey.dgroup.configuration.MapperConfiguration;
import ru.mastkey.dgroup.entity.Customer;
import ru.mastkey.dgroup.model.response.CustomerV1Response;

@Mapper(config = MapperConfiguration.class)
public interface CustomerToCustomerV1ResponseMapper extends Converter<Customer, CustomerV1Response> {
    @Override
    @Nullable
    CustomerV1Response convert(Customer customer);
}
