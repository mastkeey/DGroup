package ru.mastkey.dgroup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "customer")
public class Customer extends BaseEntity {
    @Column(name = "inn")
    private String inn;

    @Column(name = "contr_agent_info")
    private String contrAgentInfo;

    @Column(name = "transaction_subject")
    private String transactionSubject;

    @Column(name = "isRegular")
    private Boolean isRegular;

    @Column(name = "isLogisticNeeds")
    private Boolean isLogisticNeeds;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
}
