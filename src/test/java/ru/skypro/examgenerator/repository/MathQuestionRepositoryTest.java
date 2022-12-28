package ru.skypro.examgenerator.repository;

import org.junit.jupiter.api.Test;
import ru.skypro.examgenerator.entity.Question;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {

    private final MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();

    @Test
    void add() {
        var expected = new Question("test","test");
        var actual = mathQuestionRepository.add(expected);
        assertEquals(expected,actual);
        actual = mathQuestionRepository.getAll().stream().filter(obj->obj.equals(expected)).iterator().next();
        assertEquals(expected,actual);
    }

    @Test
    void remove() {
        var expected = mathQuestionRepository.add(new Question("test","test"));
        var del = mathQuestionRepository.add(new Question("test2","test2"));
        mathQuestionRepository.remove(del);
        var actual = mathQuestionRepository.getAll().stream().filter(obj->obj.equals(expected)).iterator().next();
        assertEquals(expected,actual);
    }

    @Test
    void getAll() {
        var q1 = mathQuestionRepository.add(new Question("math1","math 1"));
        var q2 = mathQuestionRepository.add(new Question("math2","math 2"));
        var q3 = mathQuestionRepository.add(new Question("math3","math 3"));
        var q4 = mathQuestionRepository.add(new Question("math4","math 4"));
        var expected = new HashSet<Question>();
        expected.add(q1);
        expected.add(q2);
        expected.add(q3);
        expected.add(q4);
        var actual = mathQuestionRepository.getAll();
        assertIterableEquals(expected,actual);
    }
}