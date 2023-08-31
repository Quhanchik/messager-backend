package kz.fakewhatsapp.fakewhatsapp.repositories;

import kz.fakewhatsapp.fakewhatsapp.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    public Chat getChatById(long id);
}
