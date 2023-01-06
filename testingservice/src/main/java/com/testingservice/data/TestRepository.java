package com.testingservice.data;

import com.testingservice.models.Test;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {
    Page<Test> findAll(Pageable page);

    Page<Test> findTestsByTitleContainsIgnoringCase(String title, Pageable page);
}
