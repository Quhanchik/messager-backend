package kz.fakewhatsapp.fakewhatsapp.services;

import kz.fakewhatsapp.fakewhatsapp.dto.ChatDTO;
import kz.fakewhatsapp.fakewhatsapp.models.Chat;
import kz.fakewhatsapp.fakewhatsapp.repositories.ChatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat getChatById(Long id) {
        return chatRepository.getChatById(id);
    }

    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }
}
