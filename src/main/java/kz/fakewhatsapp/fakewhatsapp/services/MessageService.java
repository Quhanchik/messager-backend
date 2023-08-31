package kz.fakewhatsapp.fakewhatsapp.services;

import kz.fakewhatsapp.fakewhatsapp.models.Chat;
import kz.fakewhatsapp.fakewhatsapp.models.Message;
import kz.fakewhatsapp.fakewhatsapp.repositories.MessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatService chatService;

    public MessageService(MessageRepository messageRepository, ChatService chatService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
    }
//
//    public Page<Message> findAll(Pageable pageable) {
//        return messageRepository.findAll(pageable);
//    }

    public Page<Message> findAllByChat(Chat chat, Pageable pageable) {
        return messageRepository.findAllByChatOrderByIdDesc(chat, pageable);
    }

    public Message findById(long id) {
        return messageRepository.findById(id);
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public void delete(long id) {
        messageRepository.deleteById(id);
    }
}
