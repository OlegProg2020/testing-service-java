package com.testingservice.models;

import java.util.List;
import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "question")
public class Question implements Serializable {

    @Serial
    private static final long serialVersionUID = 8776977602475032810L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;

    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Answer> answers = new ArrayList<>();
}
