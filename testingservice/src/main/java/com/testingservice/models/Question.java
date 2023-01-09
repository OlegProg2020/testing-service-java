package com.testingservice.models;

import java.util.List;
import java.util.ArrayList;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

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

    @Min(value = 1, message = "the number must be greater than or equal to 1")
    @Max(value = 200, message = "the number must be less than or equal to 200")
    private Integer number;

    @NotBlank
    @Size(min = 1, max = 500)
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @Size(min = 2, max = 20, message = "question must contain at least 2 possible answers (max 20)")
    private List<Answer> answers = new ArrayList<>();

    // todo correctAnswers сделать list или string с преобразованием проверки правильности ответа???
    @NotBlank
    @Size(min = 1, max = 100, message = "correct answers ")
    private String correctAnswer;


    private Integer score;
}
