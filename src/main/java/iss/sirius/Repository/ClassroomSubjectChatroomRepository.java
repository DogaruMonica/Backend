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

    @Query(value = "SELECT * FROM classroom_subject_chatroom csc where csc.classroom_id = : classroomid AND csc.subject_id =: subjectid", nativeQuery = true)
    ClassroomSubjectChatroom findByClassroomAndSubject(@Param("classroomid") int classroomid, @Param("subjectid") int subjectid);

    List<ClassroomSubjectChatroom> findAllByClassroom_Id(int classid);
}
