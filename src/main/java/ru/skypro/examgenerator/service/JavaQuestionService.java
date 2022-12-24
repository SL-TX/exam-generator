package ru.skypro.examgenerator.service;

import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.entity.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question ent = new Question(question,answer);
        return add(ent);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int id = random.nextInt(questions.size());
        var iter = questions.iterator();
        int i = 0;
        for(var obj : questions){
            if (i == id)
                return obj;
            i++;
        }
        return null;
    }
}
