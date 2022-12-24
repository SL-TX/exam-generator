package ru.skypro.examgenerator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.examgenerator.entity.Question;
import ru.skypro.examgenerator.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("exam/get")
@RequiredArgsConstructor
public class ExamController {

    private final ExaminerService examinerService;

    @GetMapping("{amount}")
    public Collection<Question> getExamAmount(@PathVariable("amount") Integer amount){
        return examinerService.getQuestions(amount);
    }

}
