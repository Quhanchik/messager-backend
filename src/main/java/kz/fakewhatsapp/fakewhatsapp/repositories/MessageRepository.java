package kz.fakewhatsapp.fakewhatsapp.repositories;

import kz.fakewhatsapp.fakewhatsapp.models.Chat;
import kz.fakewhatsapp.fakewhatsapp.models.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    public List<Message> findAllByChat(Chat chat);

    public Page<Message> findAllByChatOrderByIdDesc(Chat chat, Pageable pageable);
    public Message findById(long id);

    public void deleteById(Long id);
}
