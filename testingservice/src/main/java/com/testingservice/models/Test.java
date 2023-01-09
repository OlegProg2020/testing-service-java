package com.testingservice.models;

import java.util.List;
import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "test")
public class Test implements Serializable {

    @Serial
    private static final long serialVersionUID = 8459959541119641192L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private List<Question> questions = new ArrayList<>();

    public Test(String title) {
        this.title = title;
    }

    public Test(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }
}
