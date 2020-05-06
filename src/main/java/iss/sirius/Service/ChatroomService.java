package iss.sirius.Service;

import iss.sirius.Model.Chatroom;
import iss.sirius.Repository.CatalogRepository;
import iss.sirius.Repository.ChatroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatroomService {
    @Autowired
    static ChatroomRepository chatroomRepository;

    @Autowired
    public ChatroomService(ChatroomRepository chatroomRepository) {
        this.chatroomRepository = chatroomRepository;
    }
    
    public static Chatroom findById(int id){
        return chatroomRepository.findById(id).get();
    }
}
