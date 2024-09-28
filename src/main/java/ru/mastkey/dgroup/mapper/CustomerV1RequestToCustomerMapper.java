package ru.mastkey.dgroup.mapper;

import jakarta.annotation.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;
import ru.mastkey.dgroup.configuration.MapperConfiguration;
import ru.mastkey.dgroup.entity.Customer;
import ru.mastkey.dgroup.model.request.CustomerV1Request;

@Mapper(config = MapperConfiguration.class)

public interface CustomerV1RequestToCustomerMapper extends Converter<CustomerV1Request, Customer> {
    @Override
    @Nullable
    Customer convert(CustomerV1Request source);
}
