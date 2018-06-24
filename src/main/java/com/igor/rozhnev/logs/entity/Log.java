package com.igor.rozhnev.logs.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "log")
@Getter
@Setter
public class Log extends AbstractPersistable<Long>{

    private static final long serialVersionUID = 1L;

    @Column(name = "label", nullable = false, unique = true)
    @Length(max = 32 , message = "Label size must be less or equals than 32 symbols")
    private String label;
}
