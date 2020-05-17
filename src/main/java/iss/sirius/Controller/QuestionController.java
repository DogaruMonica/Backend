package iss.sirius.Controller;

import iss.sirius.Model.Classroom;
import iss.sirius.Model.Question;
import iss.sirius.Model.Quiz;
import iss.sirius.Repository.QuestionRepository;
import iss.sirius.Repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public Object getQuestion(@PathVariable int id) {
        return questionRepository.findById(id);
    }

    @RequestMapping(value = "/question/{quizId}", method = RequestMethod.POST, consumes = "application/json")
    public Object addQuestion(@RequestBody Question question, @PathVariable int quizId) throws Exception {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            question.setQuiz(quiz.get());
            return questionRepository.save(question);
        }
        else {
            throw new Exception("Invalid quiz id");
        }
    }

    @RequestMapping(value = "/question", method = RequestMethod.PUT, consumes = "application/json")
    public void updateQuestion(@RequestBody Question question) throws SQLException {
        questionRepository.save(question);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
    public void removeQuestion(@PathVariable int id) throws Exception {
        if (questionRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            questionRepository.delete(questionRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public Object getAllQuestions() {
        return questionRepository.findAll();
    }
}
