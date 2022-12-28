package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.examgenerator.entity.Question;
import ru.skypro.examgenerator.repository.JavaQuestionRepository;

import java.util.HashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    JavaQuestionService questionService;

    @Test
    void add() {

        var questions = new HashSet<Question>();
        var expected = new Question("asd","dsa");
        Mockito.when(javaQuestionRepository.add(expected)).thenReturn(expected);

        questionService.add("asd","dsa");
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(
                 new HashSet<>(){{
                     add(expected);
                 }}
        );
        var actual = questionService.getRandomQuestion();
        assertEquals(expected,actual);
    }

    @Test
    void testAdd() {
        var expected = new Question("asd","dsa");
        questionService.add(expected);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(
                new HashSet<>(){{
                    add(expected);
                }}
        );
        var actual = questionService.getRandomQuestion();
        assertEquals(expected,actual);
    }

    @Test
    void remove() {
        var q1 = new Question("asd","dsa");
        Mockito.when(javaQuestionRepository.remove(Mockito.any())).thenReturn(q1);
        assertEquals(q1,questionService.remove(q1));
    }

    @Test
    void getAll() {
        var q1 = new Question("asd","dsa");
        var q2 = new Question("asd2","dsa2");
        var expected = new HashSet<Question>();
        expected.add(q2);
        expected.add(q1);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(
                new HashSet<>(){{
                    add(q1);
                    add(q2);
                }}
        );
        var actual = questionService.getAll();
        assertIterableEquals(expected,actual);
    }

    @Test
    void getRandomQuestion() {
        var q2 = new Question("asd2","dsa2");
        Mockito.
        when(javaQuestionRepository.getAll()).thenReturn(
                new HashSet<>(){{
                    add(q2);
                }}
        );
        var actual = questionService.getRandomQuestion();
        assertEquals(q2,actual);
    }
}