package com.igor.rozhnev.logs.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="entry")
@Getter
@Setter
public class Entry extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "data", nullable = false)
    @Length(max = 1000 , message = "Data must be less than 1000 symbols")
    private String data;


    @ManyToOne()
    @JoinColumn(
            name = "log_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "entry_log_fk")
    )
    private Log log;
}
