package ru.mastkey.dgroup.model.response;

import lombok.Data;

import java.util.List;

@Data
public class CustomerV1Response {
    private String inn;
    private String phone;
    private String email;
    private List<PaymentRequestV1Response> paymentRequests;
}
