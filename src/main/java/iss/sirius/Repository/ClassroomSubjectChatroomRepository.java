package iss.sirius.Repository;

import iss.sirius.Model.Classroom;
import iss.sirius.Model.ClassroomSubjectChatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomSubjectChatroomRepository extends JpaRepository<ClassroomSubjectChatroom, Integer> {
    ClassroomSubjectChatroom findByClassroom(Classroom classroom);

    @Query(value = "SELECT * FROM classroom_subject_chatroom csc where csc.classroom_id = :classroom_id AND csc.subject_id = :subject_id", nativeQuery = true)
    ClassroomSubjectChatroom findByClassroomAndSubject(@Param("classroom_id") int classroom_id, @Param("subject_id") int subject_id);

    List<ClassroomSubjectChatroom> findAllByClassroom_Id(int classid);
}
