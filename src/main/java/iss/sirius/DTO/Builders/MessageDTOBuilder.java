package iss.sirius.DTO.Builders;

import iss.sirius.DTO.MessageDTO;
import iss.sirius.Model.Message;
import iss.sirius.Repository.ChatroomRepository;
import iss.sirius.Service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MessageDTOBuilder {

    public static MessageDTO generateDTOFromEntity(Message message) {
        return new MessageDTO(
                message.getId(),
                message.getChatroom().getId(),
                message.getMessage(),
                message.getUserId()
        );
    }

    public static Message generateEntityFromDTO(MessageDTO messageDTO) {
        return new Message(
                messageDTO.getId(),
                ChatroomService.findById(messageDTO.getChatroom()),
                messageDTO.getMessage(),
                messageDTO.getUserId(),
                LocalDateTime.now()
        );
    }
}
