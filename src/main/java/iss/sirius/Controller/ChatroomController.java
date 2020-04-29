package iss.sirius.Controller;

import iss.sirius.Model.Chatroom;
import iss.sirius.Repository.ChatroomRepository;
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
public class ChatroomController {
    @Autowired
    ChatroomRepository chatroomRepository;

    @RequestMapping(value = "/chatroom/{id}", method = RequestMethod.GET)
    public Object getChatroom(@PathVariable int id) {
        return chatroomRepository.findById(id);
    }

    @RequestMapping(value = "/chatroom", method = RequestMethod.POST, consumes = "application/json")
    public Object addChatroom(@RequestBody Chatroom chatroom) throws Exception {
        return chatroomRepository.save(chatroom);
    }

    @RequestMapping(value = "/chatroom", method = RequestMethod.PUT, consumes = "application/json")
    public void updateChatroom(@RequestBody Chatroom chatroom) throws SQLException {
        chatroomRepository.save(chatroom);
    }

    @RequestMapping(value = "/chatroom/{id}", method = RequestMethod.DELETE)
    public void removeChatroom(@PathVariable int id) throws Exception {
        if (chatroomRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            chatroomRepository.delete(chatroomRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/chatroom", method = RequestMethod.GET)
    public Object getAllChatrooms() {
        return chatroomRepository.findAll();
    }
}
