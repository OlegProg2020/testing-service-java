package com.testingservice.models;

import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "answer")
public class Answer implements Serializable {

    @Serial
    private static final long serialVersionUID = -6369568643475053241L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 1, max = 1000, message = "Content must contain from 1 to 1000 symbols")
    private String content;

    @Value(value = "${some.key:true}")
    private Boolean correct;
}
