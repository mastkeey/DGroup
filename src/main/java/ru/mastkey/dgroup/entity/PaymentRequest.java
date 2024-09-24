package ru.mastkey.dgroup.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "payment_request")
public class PaymentRequest extends BaseEntity {
    @OneToMany(mappedBy = "paymentRequest")
    private List<Comment> comment;

    @Column(name = "status")
    private String status;

    @Column(name = "date_of_request")
    private ZonedDateTime dateOfRequest;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
