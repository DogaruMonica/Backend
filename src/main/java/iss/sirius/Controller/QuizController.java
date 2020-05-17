package iss.sirius.Controller;

import iss.sirius.Model.Catalog;
import iss.sirius.Model.ClassroomSubjectChatroom;
import iss.sirius.Model.Grade;
import iss.sirius.Model.Pupil;
import iss.sirius.Model.Question;
import iss.sirius.Model.Quiz;
import iss.sirius.Model.QuizPupil;
import iss.sirius.Repository.CatalogRepository;
import iss.sirius.Repository.ClassroomSubjectChatroomRepository;
import iss.sirius.Repository.GradeRepository;
import iss.sirius.Repository.QuestionRepository;
import iss.sirius.Repository.QuizPupilRepository;
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
public class QuizController {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizPupilRepository quizPupilRepository;
    @Autowired
    ClassroomSubjectChatroomRepository classroomSubjectChatroomRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    CatalogRepository catalogRepository;

    @RequestMapping(value = "/quiz/{id}", method = RequestMethod.GET)
    public Object getQuiz(@PathVariable int id) {
        return quizRepository.findById(id);
    }

    @RequestMapping(value = "/quiz/{id}", method = RequestMethod.POST, consumes = "application/json")
    public Object addQuiz(@RequestBody Quiz quiz, @PathVariable int id) throws Exception {
        Optional<ClassroomSubjectChatroom> classroomSubjectChatroom = classroomSubjectChatroomRepository.findById(id);
        quiz.setClassroomSubjectChatroom(classroomSubjectChatroom.get());
        Quiz returnedQuiz = quizRepository.save(quiz);
        for (Pupil pupil : classroomSubjectChatroom.get().getClassroom().getPupils()) {
            QuizPupil quizPupil = new QuizPupil(quiz, pupil);
            quizPupilRepository.save(quizPupil);
        }
        return returnedQuiz;
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.PUT, consumes = "application/json")
    public void updateQuiz(@RequestBody Quiz quiz) throws SQLException {
        quizRepository.save(quiz);
    }

    @RequestMapping(value = "/quiz/{id}/toggleactive", method = RequestMethod.PUT)
    public void toggleActive(@PathVariable int id) throws SQLException {
        Quiz quiz = quizRepository.findById(id).get();
        quiz.setActive(!quiz.getActive());
        quizRepository.save(quiz);
    }

    @RequestMapping(value = "/quiz/{id}", method = RequestMethod.DELETE)
    public void removeQuiz(@PathVariable int id) throws Exception {
        if (quizRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            quizRepository.delete(quizRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.GET)
    public Object getAllQuizzes() {
        return quizRepository.findAll();
    }

    @RequestMapping(value = "/quiz/{quizId}/{questionId}/{pupilId}", method = RequestMethod.POST, consumes = "application/json")
    public void submitAnswer(@RequestBody String answer, @PathVariable int quizId, @PathVariable int questionId, @PathVariable int pupilId) throws Exception {
        Optional<Question> question = questionRepository.findById(questionId);
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        QuizPupil quizPupil = quizPupilRepository.findByPupilidAndQuizid(pupilId, quizId);
        if (question.get().getCorrectAnswer().equals(answer)) {
            quizPupil.setScore(quizPupil.getScore() + 1);
        }
    }

    @RequestMapping(value = "/quiz/{quizId}/{pupilId}", method = RequestMethod.GET)
    public int getFinalScore( @PathVariable int quizId, @PathVariable int pupilId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        Catalog catalog = catalogRepository.findByClassroom(quiz.get().getClassroomSubjectChatroom().getClassroom());
        QuizPupil quizPupil = quizPupilRepository.findByPupilidAndQuizid(pupilId, quizId);
        int quizGrade = Math.round((quizPupil.getScore() / quiz.get().getQuestions().size()) * 10);
        Grade grade = new Grade();
        grade.setGrade(quizGrade);
        grade.setPupil(pupilId);
        grade.setSubject(quiz.get().getClassroomSubjectChatroom().getSubject().getId());
        grade.setCatalog(catalog);
        gradeRepository.save(grade);
        return quizGrade;
    }
}
