package ru.skypro.examgenerator.service;

import ru.skypro.examgenerator.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
