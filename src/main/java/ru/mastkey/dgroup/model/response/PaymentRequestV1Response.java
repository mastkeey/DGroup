package ru.mastkey.dgroup.model.response;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class PaymentRequestV1Response {
    private List<CommentV1Response> comment;
    private String status;
    private ZonedDateTime dateOfRequest;
    private String contrAgentInfo;
    private String transactionSubject;
    private Boolean isRegular;
    private Boolean isLogisticNeeds;
    private UUID customerId;
}
