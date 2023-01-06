package com.testingservice.web;

import com.testingservice.models.Test;
import com.testingservice.data.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/tests")
public class TestController {

    private final TestRepository testRepository;

    @Autowired
    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    /*
    @ModelAttribute(name = "tests")
    public Iterable<Test> addTestsToModel() {
        return testRepository.findAll();
    }
    */

    @GetMapping
    public String showTestsView(Model model,
                                @RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset,
                                @RequestParam(name = "limit", required = false, defaultValue = "12") Integer limit,
                                @RequestParam(name = "title", required = false, defaultValue = "") String title) {

        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by("id").descending());
        Iterable<Test> tests;
        if(title.isBlank()) {
            tests = testRepository.findAll(pageRequest);
        }
        else {
            tests = testRepository.findTestsByTitleContainsIgnoringCase(title, pageRequest);
        }
        model.addAttribute("tests", tests);
        return "tests";
    }

}
