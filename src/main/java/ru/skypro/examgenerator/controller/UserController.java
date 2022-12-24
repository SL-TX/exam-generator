package ru.skypro.examgenerator.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("exam")
public class UserController {

    @GetMapping("get/{amount}")
    public List<Exam> getExamAmount(@PathVariable Integer amount){
        return null;
    }

    @GetMapping("/java/find")
    public Exam findExam(Integer id){
        return null;
    }

    @PostMapping("java/add")
    public Exam addExam(Exam dto){
        return null;
    }

    @DeleteMapping("java/remove")
    public void delExam(Integer id){

    }
}
