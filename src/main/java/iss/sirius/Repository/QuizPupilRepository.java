package iss.sirius.Repository;

import iss.sirius.Model.QuizPupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizPupilRepository extends JpaRepository<QuizPupil, Integer> {
    @Query(value = "SELECT * FROM quiz_pupil qp where qp.pupilid = : pupilid AND qp.quizid =: quizid", nativeQuery = true)
    QuizPupil findByPupilidAndQuizid(@Param("pupilid") int pupilid, @Param("quizid") int quizid);
}
