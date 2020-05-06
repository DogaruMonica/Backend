package iss.sirius.Repository;

import iss.sirius.Model.Message;
import iss.sirius.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query(value = "SELECT * FROM messages m where m.chatroom_id = :chatroomId", nativeQuery = true)
    List<Message> findByChatroom(@Param("chatroomId") int chatroomId);
}
