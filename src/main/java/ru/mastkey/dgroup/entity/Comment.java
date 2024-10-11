package ru.mastkey.dgroup.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import jakarta.validation.constraints.NotNull;


import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "comment")
public class Comment extends BaseEntity {
    @Column(name = "text")
    private String text;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Customer sender;

    @Column(name = "dateOfMessage")
    private ZonedDateTime dateOfMessage;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_request_id", referencedColumnName = "id")
    private PaymentRequest paymentRequest;
}
