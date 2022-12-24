package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.skypro.examgenerator.entity.Question;

import java.util.HashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @Test
    void add() {
        questionService.add("asd","dsa");
        var expected = new Question("asd","dsa");
        var actual = questionService.getRandomQuestion();
        assertEquals(expected,actual);
    }

    @Test
    void testAdd() {
        var expected = new Question("asd","dsa");
        questionService.add(expected);
        var actual = questionService.getRandomQuestion();
        assertEquals(expected,actual);
    }

    @Test
    void remove() {
        var q1 = new Question("asd","dsa");
        var q2 = new Question("asd2","dsa2");
        questionService.add(q1);
        questionService.add(q2);
        assertEquals(2,questionService.getAll().size());
        questionService.remove(q1);
        assertEquals(1,questionService.getAll().size());
        var actual = questionService.getRandomQuestion();
        assertEquals(q2,actual);
    }

    @Test
    void getAll() {
        var q1 = new Question("asd","dsa");
        var q2 = new Question("asd2","dsa2");
        questionService.add(q1);
        questionService.add(q2);
        var expected = new HashSet<Question>();
        expected.add(q2);
        expected.add(q1);
        var actual = questionService.getAll();
        assertIterableEquals(expected,actual);
    }

    @Test
    void getRandomQuestion() {
        Random randomNumberMock = Mockito.mock(Random.class, withSettings().withoutAnnotations());
        when(randomNumberMock.nextInt(anyInt())).thenReturn(2);
        var q1 = new Question("asd","dsa");
        var q2 = new Question("asd2","dsa2");
        var q3 = new Question("asd3","dsa3");
        questionService.add(q1);
        questionService.add(q2);
        questionService.add(q3);
        var actual = questionService.getRandomQuestion();
        assertEquals(q2,actual);
    }
}