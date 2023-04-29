package com.only4play.jpa.support;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseJpaAggregate extends AbstractAggregateRoot<BaseJpaAggregate> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Setter(AccessLevel.PROTECTED)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Setter(AccessLevel.PROTECTED)
    private Date updatedAt;

    @PrePersist
    public void prePersist() {
        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());
    }

    @PreUpdate
    public void preUpdate() {
        this.setUpdatedAt(new Date());
    }

}
