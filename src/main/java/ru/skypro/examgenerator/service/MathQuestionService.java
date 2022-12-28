package ru.skypro.examgenerator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.entity.Question;
import ru.skypro.examgenerator.repository.MathQuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
@Qualifier("MathQuestionService")
@RequiredArgsConstructor
public class MathQuestionService implements QuestionService {
    private final MathQuestionRepository mathQuestionRepository;
    @Override
    public Question add(String question, String answer) {
        Question ent = new Question(question,answer);
        return add(ent);
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    private final Random random = new Random();
    @Override
    public Question getRandomQuestion() {
        var questions = mathQuestionRepository.getAll();

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
