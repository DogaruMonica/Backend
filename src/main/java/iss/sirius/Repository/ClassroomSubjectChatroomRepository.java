package iss.sirius.Repository;

import iss.sirius.Model.ClassroomSubjectChatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomSubjectChatroomRepository extends JpaRepository<ClassroomSubjectChatroom, Integer> {

    List<ClassroomSubjectChatroom> findAllByClassroom_Id(int classid);
}
