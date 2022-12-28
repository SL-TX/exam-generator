package ru.skypro.examgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.examgenerator.entity.Question;

import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    @Qualifier("JavaQuestionService")
    private final QuestionService javaQuestionService;

    @Qualifier("MathQuestionService")
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var result = new ArrayList<Question>();
        int i = 0;
        while (result.size() < amount){
            var question = Math.random()>=0.5?javaQuestionService.getRandomQuestion():mathQuestionService.getRandomQuestion();
            if (i<=5 && !result.contains(question)) {
                result.add(question);
                i=0;
            } else {
                throw new ResponseStatusException(BAD_REQUEST,"Bad request");
            }
            i++;
        }
        return result;
    }
}
