package ru.skypro.examgenerator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.examgenerator.entity.Question;
import ru.skypro.examgenerator.service.QuestionService;

@RestController
@RequestMapping("exam/java")
@RequiredArgsConstructor
public class JavaController {

    private final QuestionService questionService;

    @GetMapping("find")
    public Question findExam(Integer id){
        return questionService.getRandomQuestion();
    }

    @PostMapping("add")
    public Question addExam(Question dto){
        return questionService.add(dto);
    }

    @DeleteMapping("remove")
    public Question delExam(Question dto){
        return questionService.remove(dto);
    }
}
