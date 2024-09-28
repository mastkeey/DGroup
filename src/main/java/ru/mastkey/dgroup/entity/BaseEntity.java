package ru.mastkey.dgroup.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@MappedSuperclass
@Accessors(chain = true)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (isNull(o) || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        var that = (BaseEntity) Hibernate.getClass(this).cast(o);

        return nonNull(getId()) && getId().equals(that.getId());
    }

    @Override
    public final int hashCode() {
        return isNull(getId())
                ? Hibernate.getClass(this).hashCode()
                : Objects.hashCode(getId());
    }
}
