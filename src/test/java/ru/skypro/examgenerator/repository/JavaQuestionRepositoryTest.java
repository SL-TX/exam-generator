package ru.skypro.examgenerator.repository;

import org.junit.jupiter.api.Test;
import ru.skypro.examgenerator.entity.Question;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();

    @Test
    void add() {
        var expected = new Question("test","test");
        var actual = javaQuestionRepository.add(expected);
        assertEquals(expected,actual);
        actual = javaQuestionRepository.getAll().iterator().next();
        assertEquals(expected,actual);
    }

    @Test
    void remove() {
        var expected = javaQuestionRepository.add(new Question("test","test"));
        var del = javaQuestionRepository.add(new Question("test2","test2"));
        javaQuestionRepository.remove(del);
        var actual = javaQuestionRepository.getAll().iterator().next();
        assertEquals(expected,actual);
    }

    @Test
    void getAll() {
        var q1 = javaQuestionRepository.add(new Question("test","test"));
        var q2 = javaQuestionRepository.add(new Question("test","test"));
        var expected = new HashSet<Question>();
        expected.add(q1);
        expected.add(q2);
        javaQuestionRepository.add(q1);
        javaQuestionRepository.add(q2);
        var actual = javaQuestionRepository.getAll();
        assertIterableEquals(expected,actual);
    }
}