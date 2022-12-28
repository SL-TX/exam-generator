package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.skypro.examgenerator.entity.Question;
import ru.skypro.examgenerator.repository.MathQuestionRepository;

import java.util.HashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

class MathQuestionServiceTest {

    private final QuestionService questionService = new MathQuestionService(new MathQuestionRepository());

    @Test
    void add() {
        questionService.add("asd","dsa");
        var expected = new Question("asd","dsa");
        var actual = questionService.getAll().stream().reduce((prev, next) -> next).orElse(null);
        assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        var expected = new Question("asd","dsa");
        questionService.add(expected);
        var actual = questionService.getAll().stream().reduce((prev, next) -> next).orElse(null);
        assertEquals(expected,actual);
    }

    @Test
    void remove() {
        var init = questionService.getAll();
        var q1 = init.iterator().next();
        questionService.remove(q1);
        assertEquals(3,questionService.getAll().size());
        var q2 = init.iterator().next();
        questionService.remove(q2);
        assertEquals(2,questionService.getAll().size());
        var actual = questionService.getAll().iterator().next();
        assertEquals(new Question("math1","math 1"),actual);
    }

    @Test
    void getAll() {
        var init = questionService.getAll();
        questionService.remove(init.iterator().next());
        questionService.remove(init.iterator().next());

        var q1 = new Question("math1","math 1");
        var q2 = new Question("math2","math 2");
        var expected = new HashSet<Question>();
        expected.add(q2);
        expected.add(q1);
        var actual = questionService.getAll();
        assertIterableEquals(expected,actual);
    }

    @Test
    void getRandomQuestion() {
        Random randomNumberMock = Mockito.mock(Random.class, withSettings().withoutAnnotations());
        when(randomNumberMock.nextInt(anyInt())).thenReturn(4);
        var expected = new Question("math4","math 4");
        var actual = questionService.getRandomQuestion();
        assertEquals(expected,actual);
    }
}