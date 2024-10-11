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

    @Column(name = "contr_agent_info")
    private String contrAgentInfo;

    @Column(name = "transaction_subject")
    private String transactionSubject;

    @Column(name = "isRegular")
    private Boolean isRegular;

    @Column(name = "isLogisticNeeds")
    private Boolean isLogisticNeeds;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
