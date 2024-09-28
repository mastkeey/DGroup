package ru.mastkey.dgroup.model.response;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.mastkey.dgroup.entity.PaymentRequest;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class CommentV1Response {
    private String text;
    private UUID senderId;
    private ZonedDateTime dateOfMessage;
}
