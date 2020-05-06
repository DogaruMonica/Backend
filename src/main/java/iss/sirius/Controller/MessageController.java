package iss.sirius.Controller;

import iss.sirius.DTO.MessageDTO;
import iss.sirius.Event.BaseEvent;
import iss.sirius.Event.CreateMessageEvent;
import iss.sirius.Model.Message;
import iss.sirius.Repository.MessageRepository;
import iss.sirius.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageService messageService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public Object getMessage(@PathVariable int id) {
        return messageRepository.findById(id);
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST, consumes = "application/json")
    public Object addMessage(@RequestBody MessageDTO messageDTO) throws Exception {
        return messageService.save(messageDTO);
    }

    @RequestMapping(value = "/message", method = RequestMethod.PUT, consumes = "application/json")
    public void updateMessage(@RequestBody Message message) throws SQLException {
        messageRepository.save(message);
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
    public void removeMessage(@PathVariable int id) throws Exception {
        if (messageRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            messageRepository.delete(messageRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public Object getAllMessages() {
        return messageRepository.findAll();
    }

    @RequestMapping(value = "/chatroom/{id}/message", method = RequestMethod.GET)
    public Object getAllChatroomMessages(@PathVariable int id) throws Exception {
        return messageRepository.findByChatroom(id);
    }

    @EventListener(CreateMessageEvent.class)
    public void handleEvent(CreateMessageEvent event) {
        System.out.println(event.toString());
        simpMessagingTemplate.convertAndSend("/topic/events", event.getMessage());

    }
}
