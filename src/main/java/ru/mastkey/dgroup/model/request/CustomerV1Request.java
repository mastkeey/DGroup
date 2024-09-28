package ru.mastkey.dgroup.model.request;

import lombok.Data;

@Data
public class CustomerV1Request {
    private String inn;
    private String phone;
}
