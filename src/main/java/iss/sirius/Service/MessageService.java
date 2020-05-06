package iss.sirius.Service;

import iss.sirius.DTO.Builders.MessageDTOBuilder;
import iss.sirius.DTO.MessageDTO;
import iss.sirius.Event.CreateMessageEvent;
import iss.sirius.Model.Message;
import iss.sirius.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public Message save(MessageDTO messageDTO) {
        Message message = MessageDTOBuilder.generateEntityFromDTO(messageDTO);
        Message returnedMessage = messageRepository.save(message);
        applicationEventPublisher.publishEvent(new CreateMessageEvent(returnedMessage));
        return returnedMessage;
    }
}
