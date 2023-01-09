package com.testingservice.models;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "answer")
public class Answer implements Serializable {

    @Serial
    private static final long serialVersionUID = -6369568643475053241L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // todo создать ограничения как в Test и Answer
    private String content;
}
