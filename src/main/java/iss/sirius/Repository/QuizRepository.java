package iss.sirius.Repository;

import iss.sirius.Model.ClassroomSubjectChatroom;
import iss.sirius.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    List<Quiz> findByClassroomSubjectChatroom(ClassroomSubjectChatroom classroomSubjectChatroom);
}
