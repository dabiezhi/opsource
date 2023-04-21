package com.only4play.jpa.support;

import java.time.LocalDateTime;

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
    //    @Convert(converter = InstantLongConverter.class)
    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    //    @Convert(converter = InstantLongConverter.class)
    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime updatedAt;

    //    @Version
    //    @Column(name = "version")
    //    @Setter(AccessLevel.PRIVATE)
    //    private Integer version;

    @PrePersist
    public void prePersist() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.setUpdatedAt(LocalDateTime.now());
    }

}
