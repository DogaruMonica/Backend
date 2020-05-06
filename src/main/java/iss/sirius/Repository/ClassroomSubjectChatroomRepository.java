package iss.sirius.Repository;

import iss.sirius.Model.ClassroomSubjectChatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomSubjectChatroomRepository extends JpaRepository<ClassroomSubjectChatroom, Integer> {
}
