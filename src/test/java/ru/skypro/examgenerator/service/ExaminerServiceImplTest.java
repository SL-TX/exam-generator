package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.examgenerator.entity.Question;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;
    @Test
    void getQuestions() {
        var q1=new Question("q1","123");
        var q2=new Question("q2","123");
        var q3=new Question("q3","123");
        var q4=new Question("q4","123");
        var q5=new Question("q5","123");
        Mockito.when(questionService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q2)
                .thenReturn(q3)
                .thenReturn(q4)
                .thenReturn(q5);
        var set = new ArrayList<Question>();
        set.add(q1);
        set.add(q2);
        set.add(q3);
        set.add(q4);
        set.add(q5);
        var expected = set;
        var actual = examinerService.getQuestions(5);
        assertIterableEquals(expected,actual);

    }

}